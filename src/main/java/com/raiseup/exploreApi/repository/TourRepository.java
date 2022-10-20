package com.raiseup.exploreApi.repository;

import com.raiseup.exploreApi.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour,Long> {
}
