package com.murtekbey.springbootpetclinicdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "t_vet")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGen")
    @SequenceGenerator(
            name = "petClinicSeqGen",
            sequenceName = "petclinic_sequence",
            allocationSize = 1)
    @Getter
    @Setter
    private Long id;

    @NotEmpty
    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;
}
