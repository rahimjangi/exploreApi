package com.raiseup.exploreApi.service;

import com.raiseup.exploreApi.repository.TourPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourPackageService  {
    private final TourPackageRepository tourPackageRepository;
}
