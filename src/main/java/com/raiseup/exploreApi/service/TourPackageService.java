package com.raiseup.exploreApi.service;

import com.raiseup.exploreApi.model.TourPackage;
import com.raiseup.exploreApi.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourPackageService {
    private final TourPackageRepository tourPackageRepository;

    public TourPackage createTourPackage(TourPackage tourPackage) {
        if (tourPackageRepository.findByCode(tourPackage.getCode()).isEmpty()) {

            return tourPackageRepository.save(tourPackage);
        }
        TourPackage findedTourPackage = tourPackageRepository.findByCode(tourPackage.getCode()).get();
        findedTourPackage.setName(tourPackage.getName());
        return tourPackageRepository.save(findedTourPackage);
    }

    public List<TourPackage> findAll(){
        return tourPackageRepository.findAll();
    }
    public Long tourPackageCount(){
        return tourPackageRepository.count();
    }


    public Optional<TourPackage> findByName(String packageType) {
        return tourPackageRepository.findByName(packageType);
    }
}
