package com.pet.depo23.repository;

import jakarta.transaction.Transactional;
import com.pet.depo23.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface TradeRepository extends JpaRepository<Trade, Long> {
}