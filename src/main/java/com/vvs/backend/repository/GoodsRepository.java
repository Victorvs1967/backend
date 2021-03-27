package com.vvs.backend.repository;

import java.util.Optional;

import com.vvs.backend.model.Goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Optional<Goods> findById(Long id);
}
