package com.orion.DigiWallet.controller;

import com.orion.DigiWallet.model.Wallet;
import com.orion.DigiWallet.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//TODO: 4.2.1 : Create WalletController class with necessary annotations
// to make it a REST controller handling requests at /api/wallets
@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private static final Logger logger =
            LoggerFactory.getLogger(WalletController.class);

    //TODO: 4.2.2:
    // Declare a private final variable for WalletService
    private final WalletService walletService;


    //TODO: 4.2.3:
    // Create a constructor that accepts WalletService as a parameter
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    //TODO: 4.2.4:
    // Implement the GET WALLET BY ID API
    // -------------------------
    // http://localhost:8080/api/wallets/{id}
    // GET METHOD
    // RESPONSE BODY: Wallet JSON
    // Call getWalletById method from WalletService
    // Use @GetMapping and @PathVariable annotations
    // Example: GET /api/wallets/5
    // Log the request using logger.info
    // RETURN the Wallet object obtained from the service
    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Long id){
        logger.info("Wallet found with id: "+ id);
        return walletService.getWalletById(id);
    }

    //TODO: 4.2.5:
    // Implement the GET WALLET BY USER ID API
    // -------------------------
    // http://localhost:8080/api/wallets/user/{userId}
    // GET METHOD
    // RESPONSE BODY: Wallet JSON
    // Call getWalletByUserId method from WalletService
    // Use @GetMapping and @PathVariable annotations
    // Example: GET /api/wallets/user/8
    // Log the request using logger.info
    // RETURN the Wallet object obtained from the service
    // GET WALLET BY USER ID
    @GetMapping("/user/{userid}")
    public Wallet getWalletByUserId(@PathVariable Long userid){
        logger.info("Wallet found with userid: "+ userid);
        return walletService.getWalletByUserId(userid);
    }


    //TODO: 4.2.6:
    // CREATE WALLET API
    // -------------------------
    // http://localhost:8080/api/wallets
    // {
    //  "user": { "id": 8 },
    //  "balance": 5000,
    //  "currency": "INR"
    // }
    // POST METHOD
    // REQUEST BODY: Wallet JSON
    // RESPONSE BODY: Created Wallet JSON

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Wallet createWallet(@RequestBody Wallet wallet){
        logger.info("Created wallet");
        return walletService.createWallet(wallet);
    }

}
