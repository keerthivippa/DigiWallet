package com.orion.DigiWallet.repository;

import com.orion.DigiWallet.model.User;
import com.orion.DigiWallet.model.Wallet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
//TODO: 3.7: remove @Disabled to enable the tests
// Go though the complete walletRepositoryTest and answer or discuss with fellow engineers
// Q1: Do you see any similarities with other repository tests you have done so far?
// Q2: What is the purpose of @DataJpaTest annotation here?
// Q3: Why is it important to have test cases like these for repositories?
// Q4: How does this test ensure the integrity of data operations in the application?
// Q5: What would happen if the walletRepository.findByUserId method did not work as expected?
//@Disabled
class WalletRepositoryTest {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserId_shouldReturnWallet_whenWalletExistsForUser() {
        // Arrange: create and save user and wallet
        User user = new User();
        user.setUsername("testuser_find");
        user.setFullName("Test User");
        user.setEmail("test-find@example.com");
        user.setRole("USER");
        user.setStatus("ACTIVE");
        user = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(BigDecimal.valueOf(1000));
        wallet.setCurrency("INR");
        wallet.setStatus("ACTIVE");
        wallet = walletRepository.save(wallet);

        // Act
        Optional<Wallet> opt = walletRepository.findByUserId(user.getId());

        // Assert
        assertThat(opt).isPresent();
        assertThat(opt.get().getId()).isEqualTo(wallet.getId());
        assertThat(opt.get().getUser().getId()).isEqualTo(user.getId());
    }

    @Test
    void findByUserId_shouldReturnEmpty_whenNoWalletForUser() {
        // Arrange: create and save a user without wallet
        User user = new User();
        user.setUsername("testuser_nosave");
        user.setFullName("No Wallet");
        user.setEmail("no-wallet@example.com");
        user.setRole("USER");
        user.setStatus("ACTIVE");
        user = userRepository.save(user);

        // Act
        Optional<Wallet> opt = walletRepository.findByUserId(user.getId());

        // Assert
        assertThat(opt).isNotPresent();
    }
}
