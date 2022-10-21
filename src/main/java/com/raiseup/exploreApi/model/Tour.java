package com.raiseup.exploreApi.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Tour {
    @Id
    @GeneratedValue(generator = "tour_seq",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String description;
    private String blurb;
    private BigDecimal price;
    private String duration;
    private String bullets;
    private String keywords;
    @ManyToOne
    private TourPackage tourPackage;
    private Difficulty difficulty;
    private Region region;

    public Tour(String title, String description, String blurb, BigDecimal price, String duration, String bullets, String keywords, TourPackage tourPackage, Difficulty difficulty, Region region) {
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }
}
