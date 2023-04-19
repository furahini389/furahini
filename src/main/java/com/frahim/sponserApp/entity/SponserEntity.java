package com.frahim.sponserApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sponserInfo")
public class SponserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "financial_resources")
    String financial_resources;
    @Column(name = "reputation")
    String reputation;
    @Column(name = "expertise")
    String expertise;
    @Column(name = "brandAlignment")
    String brandAlignment;
    @Column(name = "network")
    String network;
    @Column(name = "ethicalValue")
    String ethicalValue;
}
