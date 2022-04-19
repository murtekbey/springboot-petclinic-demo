package com.murtekbey.springbootpetclinicdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_pet")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "owner"})
public class Pet {

  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petClinicSeqGen")
  @SequenceGenerator(
      name = "petClinicSeqGen",
      sequenceName = "petclinic_sequence",
      allocationSize = 1)
  private Long id;

  @Getter
  @Setter
  @Column(name = "name")
  private String name;

  @Getter
  @Setter
  @Column(name = "birth_date")
  private Date birthDate;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

//  @Override
//  public String toString() {
//    return "Pet [id="
//        + getId()
//        + ", name="
//        + name
//        + ", birthDate="
//        + birthDate
//        + ", owner="
//        + owner
//        + "]";
//  }
}
