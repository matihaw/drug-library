package org.druglibrary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drug")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
final public class Drug {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "administration_route", columnDefinition = "TEXT")
    private String administrationRoute;

    @Column(name = "pharmaceutical_form")
    private String pharmaceuticalForm;

    @Column(name = "marketing_authorization_holder")
    private String marketingAuthorizationHolder;

    @Column(name = "active_substance", columnDefinition = "TEXT")
    private String activeSubstance;

    @Column(name = "manufacturer_name", columnDefinition = "TEXT")
    private String manufacturerName;

    @Column(name = "leaflet")
    private String leaflet;
}
