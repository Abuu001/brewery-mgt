package com.lugonzo.msscbeerservice.repository;

import com.lugonzo.msscbeerservice.model.BeerDto;
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerRepository extends JpaRepository<BeerDto, UUID> {
}
