package com.orion.DigiWallet.repository;

import com.orion.DigiWallet.model.Card;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//TODO: 2.2
//make this class a repository for Card entity use annotation
//make this interface extend JpaRepository with Card as entity and Long as ID type


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    // TODO: 3.1
    // Write a method to find a card by cardNumber
    // Hint: Use Spring Data JPA method naming
    // Example return type: Optional<Card>
    Optional<Card> findByCardNumber(String cardNumber);

    // TODO: 3.2
    // Write a method to check if a card exists by cardNumber
    boolean existsByCardNumber(String cardNumber);
}

