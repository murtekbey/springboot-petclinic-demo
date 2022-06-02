package com.murtekbey.springbootpetclinicdemo;

import com.murtekbey.springbootpetclinicdemo.model.Owner;
import com.murtekbey.springbootpetclinicdemo.model.Vet;
import com.murtekbey.springbootpetclinicdemo.service.PetClinicService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=dev"})
public class PetClinicIntegrationTests {

  @Autowired private PetClinicService petClinicService;

  @Test
  public void testFindOwners() {
    List<Owner> owners = petClinicService.findOwners();

    MatcherAssert.assertThat(owners.size(), Matchers.equalTo(10));
  }

  @Test
  public void testFindVets() {
    List<Vet> vets = petClinicService.findVets();
    MatcherAssert.assertThat(vets.size(), Matchers.equalTo(3));
  }
}
