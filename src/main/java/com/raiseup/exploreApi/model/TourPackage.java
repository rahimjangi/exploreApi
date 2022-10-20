package com.raiseup.exploreApi.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TourPackage implements Serializable {

    @Id
    @GeneratedValue(generator = "tourpackage_seq",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String name;
}
