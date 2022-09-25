package com.juandavid.mutantes.mutantes.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stats")
public class StatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "count_human_dna")
    private Integer countHumanDna;

    @Column( name = "count_mutant")
    private Integer countMutant;
}
