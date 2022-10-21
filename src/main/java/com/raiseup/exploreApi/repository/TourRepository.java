package com.raiseup.exploreApi.repository;

import com.raiseup.exploreApi.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourRepository extends JpaRepository<Tour,Long> {
    Optional<Tour> findByTitle(String code);
}
