package com.raiseup.exploreApi.service;

import com.raiseup.exploreApi.model.Tour;
import com.raiseup.exploreApi.model.TourPackage;
import com.raiseup.exploreApi.repository.TourPackageRepository;
import com.raiseup.exploreApi.repository.TourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    public Tour createTour(Tour tour) {
        if (tourRepository.findByTitle(tour.getTitle()).isEmpty()) {
            return tourRepository.save(tour);
        }
        TourPackage tourPackage= tourPackageRepository.findByCode(tour.getTourPackage().getCode()).get();
        Tour findedTour = tourRepository.findByTitle(tour.getTitle()).get();
        findedTour.setBlurb(tour.getBlurb());
        findedTour.setDescription(tour.getDescription());
        findedTour.setDuration(tour.getDuration());
        findedTour.setDifficulty(tour.getDifficulty());
        findedTour.setKeywords(tour.getKeywords());
        findedTour.setRegion(tour.getRegion());
        findedTour.setTourPackage(tourPackage);
        return tourRepository.save(findedTour);
    }

    public List<Tour> findAll(){
        return tourRepository.findAll();
    }
    public Long tourCount(){
        return tourRepository.count();
    }

}
