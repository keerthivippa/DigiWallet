package com.orion.DigiWallet.repository;

import com.orion.DigiWallet.model.Category;
import com.orion.DigiWallet.model.Transaction;
import com.orion.DigiWallet.model.User;
import com.orion.DigiWallet.model.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
// FIRST SEE THE APPLICATION.PROPERTIES IN TEST RESOURCES FOLDER
// ALSO LOOK AT THE DBSCIPT.SQL AND DATAINSERT.SQL FILES IN MAIN FOLDER
//RUN THE SHELL SCRIPT TO CREATE THE TABLES IN TEST DATABASE BEFORE RUNNING THE TESTS
//TODO: 3.6.1: REMOVE @Disabled TO ENABLE THE TESTS
//@Disabled
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private User user;
    private Wallet wallet;
    private Category category;

    @BeforeEach
    void setUp() {
        // Create and persist User
        User user = new User();
        user.setUsername("Test User");
        user.setEmail("txn.user@test.com");
        this.user = userRepository.save(user);

        // Create and persist Wallet linked to User
        Wallet wallet = new Wallet();
        wallet.setUser(this.user);
        wallet.setBalance(BigDecimal.valueOf(1000)); // balance: 1000
        wallet.setCurrency("INR");                   // currency: INR
        wallet.setStatus("ACTIVE");                  // status: ACTIVE
        this.wallet = walletRepository.save(wallet);

        // Create and persist Category
        Category category = new Category();
        category.setType("EXPENSE");                 // type: EXPENSE
        category.setName("Movie");                   // example category name
        this.category = categoryRepository.save(category);
    }


    //TODO: 3.6.5: READ ONLY
    // Write a test to verify:
    // - Transaction can be saved successfully
    // - Transaction ID is generated
//    @Disabled
    @Test
    void shouldSaveTransactionSuccessfully() {
        // GIVEN
        Transaction transaction = new Transaction();
        transaction.setWallet(wallet);
        transaction.setCategory(category);
        transaction.setAmount(250.0);
        transaction.setTransactionType("DEBIT");
        transaction.setReferenceId("TXN-TEST-001");

        // WHEN
        Transaction savedTransaction = transactionRepository.save(transaction);

        // THEN
        assertThat(savedTransaction.getId()).isNotNull();
    }

    // TODO: 3.6.6:
    // Write a test to verify:
    // - Transactions can be fetched by User ID
    @Disabled
    @Test
    void shouldFindTransactionsByUserId() {
        // GIVEN
        Transaction txn1 = new Transaction();
        txn1.setWallet(wallet);
        txn1.setCategory(category);
        txn1.setAmount(250.0);
        txn1.setTransactionType("DEBIT");
        txn1.setReferenceId("TXN-USER-001");

        Transaction txn2 = new Transaction();
        txn2.setWallet(wallet);
        txn2.setCategory(category);
        txn2.setAmount(500.0);
        txn2.setTransactionType("DEBIT");
        txn2.setReferenceId("TXN-USER-002");

        transactionRepository.save(txn1);
        transactionRepository.save(txn2);

        // WHEN
        List<Transaction> transactions = transactionRepository.findByWallet_User_Id(user.getId());

        // THEN
        assertThat(transactions).isNotEmpty();
        assertThat(transactions).hasSize(2);
        assertThat(transactions)
                .extracting(Transaction::getReferenceId)
                .containsExactlyInAnyOrder("TXN-USER-001", "TXN-USER-002");
    }

    // TODO: 3.6.7
    // Write a test to verify:
    // - Empty list is returned when no transactions exist for user
//    @Disabled
    @Test
    void shouldReturnEmptyListWhenNoTransactionsForUser() {
        // GIVEN
        // No transactions are created or saved for this user

        // WHEN
        List<Transaction> transactions = transactionRepository.findByWallet_User_Id(user.getId());

        // THEN
        assertThat(transactions).isEmpty();
    }

}
