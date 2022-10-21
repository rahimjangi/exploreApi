package com.raiseup.exploreApi.repository;

import com.raiseup.exploreApi.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TourPackageRepository extends JpaRepository<TourPackage,Long> {
    Optional<TourPackage> findByCode(String code);
    Optional<TourPackage>findByName(String name);
}
