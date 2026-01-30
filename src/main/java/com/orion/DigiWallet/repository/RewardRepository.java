package com.orion.DigiWallet.repository;

import com.orion.DigiWallet.model.RewardsPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<RewardsPoint,Long> {
}
