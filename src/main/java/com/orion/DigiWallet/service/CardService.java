package com.orion.DigiWallet.service;

import com.orion.DigiWallet.model.Card;
import com.orion.DigiWallet.repository.CardRepository;
import org.springframework.stereotype.Service;

//TODO: 2.1.0
// annotate the class to be a service component
@Service
public class CardService {

    //TODO: 2.1.1
    // create a private final field for CardRepository (dependency)
    private final CardRepository cardRepository;

    //TODO: 2.1.2
    // create a constructor to inject CardRepository
    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    //TODO: 2.1.3
    // -----------------------------------------
    // CREATE CARD
    // -----------------------------------------
    // After completion of this method, you can test with swagger UI and using unit tests
    public Card createCard(Card card) {

        // STEP 1: Check if card number already exists
        // to ensure uniqueness of card numbers in the system
        // throw runtime exception if it exists "Card number already exists"

        // STEP 2: Save and return the card

        if(cardRepository.existsByCardNumber(card.getCardNumber())){
            throw new RuntimeException("Card number already exists");
        }

        return cardRepository.save(card);
    }

    //TODO: 2.1.4
    // -----------------------------------------
    // GET CARD BY ID
    // -----------------------------------------
    // After completion of this method, you can test with swagger UI and using unit tests
    public Card getCardById(Long id) {

        // STEP 1: Fetch card by ID
        // throw runtime exception if not found "Card not found with id: " + id
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id: "+id));
        return card;
    }

    //TODO: 2.1.5
    // -----------------------------------------
    // UPDATE CARD
    // -----------------------------------------
    // After completion of this method, you can test with swagger UI and using unit tests
    public Card updateCard(Long id, Card updatedCard) {

        // STEP 1: Fetch existing card
        // throw runtime exception if not found "Card not found with id: " + id
       ;
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id: "+id));


        // STEP 2: Update allowed fields
        // For simplicity, assume all fields except id and cardNumber can be updated
        // from updatedCard object get the values and set them to existingCard which you fetched in STEP 1
//        if ("ACTIVE".equalsIgnoreCase(card.getStatus())) {
//            card.setStatus("INACTIVE");
//        } else {
//            card.setStatus("ACTIVE");
//        }
        card.setStatus(updatedCard.getStatus());
        card.setExpiryDate(updatedCard.getExpiryDate());
        card.setCardType(updatedCard.getCardType());
        card.setIssuedAt(updatedCard.getIssuedAt());
        // STEP 3: Save updated card
        return cardRepository.save(card);
    }

    //TODO: 2.1.6
    // -----------------------------------------
    // DELETE CARD
    // -----------------------------------------
    // After completion of this method, you can test with swagger UI and using unit tests
    public void deleteCard(Long id) {

        // STEP 1: Check if card exists
        // throw runtime exception if not found "Card not found with id: " + id
        if (cardRepository.existsById(id))
        {
            cardRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Card not found with id: "+id);
        };

        // STEP 2: Delete card
    }
}
