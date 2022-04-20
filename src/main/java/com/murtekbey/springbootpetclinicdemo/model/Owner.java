package com.murtekbey.springbootpetclinicdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_owner")
public class Owner {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="petClinicSeqGen")
    @SequenceGenerator(name="petClinicSeqGen",sequenceName="petclinic_sequence", allocationSize = 1)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler","pets"})
    private Long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    @NotEmpty
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    @NotEmpty
    private String lastName;

    @Getter
    @Setter
    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pets=" + pets +
                '}';
    }
}
