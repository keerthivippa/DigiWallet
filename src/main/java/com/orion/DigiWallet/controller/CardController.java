package com.orion.DigiWallet.controller;

import com.orion.DigiWallet.model.Card;
import com.orion.DigiWallet.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//TODO: 4.4.1 review card controller api
// review using swagger ui
// also test using unit testing check testing class if exists

@RestController
@RequestMapping("/api/cards")
public class CardController {


    // private cardservice variable here
    // Inject CardService using constructor injection
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //TODO: 4.4.2 USE REQUESTSTATUS ANNOTATION TO RETURN 201 CREATED STATUS
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    //TODO: 4.4.3 USE REQUESTSTATUS ANNOTATION TO RETURN 200 OK STATUS
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    //TODO: 4.4.4 USE REQUESTSTATUS ANNOTATION TO RETURN 200 OK STATUS
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Card updateCard(
            @PathVariable Long id,
            @RequestBody Card updatedCard) {

        return cardService.updateCard(id, updatedCard);
    }

    //TODO: 4.4.5 USE REQUESTSTATUS ANNOTATION TO RETURN 200 OK STATUS
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return "Card deleted successfully";
    }
}
