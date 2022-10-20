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
    private Regional regional;
}
