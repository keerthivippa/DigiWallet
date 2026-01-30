package com.orion.DigiWallet.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//TODO: 3.3
// Define this class as a JPA entity mapped to "rewards_point" table
// ADD @table annotation to specify the table name as "rewards_point"
@Entity
@Table(name="rewards_point")
public class RewardsPoint {

    //TODO: 3.3.1
    // Define id as primary key with auto-generation strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TODO: 3.3.2
    // Define points field to store the number of reward points
    private int points;

    //TODO: 3.3.3
    // Define wallet field to establish many-to-one relationship with Wallet entity
    // Use @JoinColumn with name "wallet_id" and make it NOT NULL
@ManyToOne
    @JoinColumn(name="wallet_id",nullable=false)
    private Wallet wallet;
    //TODO: 3.3.4
    // Define updatedAt field to store the timestamp of last update
    // This value should be automatically updated whenever points are modified

    private LocalDateTime updateAt;
    @PrePersist
    public void prePersist(){
        updateAt=LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        updateAt=LocalDateTime.now();
    }
    //TODO: 3.3.5
    // Generate getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    //TODO: 3.3.6
    // THIS TABLE IS NOT THERE IN MYSQL SO WHEN YOU RUN IT JPA WILL CREATE IT AUTOMATICALLY
    // GO TO MYSQL AND VERIFY IF THE TABLE IS CREATED OR NOT
    // ALSO CHECK FIELD NAMES AND TYPES
    // WITH CONSTRAINTS


}
