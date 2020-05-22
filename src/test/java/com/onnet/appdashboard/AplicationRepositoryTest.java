package com.onnet.appdashboard;

import com.onnet.appdashboard.domain.model.Aplication;
import com.onnet.appdashboard.domain.repository.AplicationRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AplicationRepositoryTest {

    @Autowired
    private AplicationRepository aplicationRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShouldPersistData(){
        Aplication aplication = new Aplication(1L , "MKSolutions", "www.mk.com", true, "www.img.com");
      assertThat(aplication.getId()).isNotNull();
      assertThat(aplication.getUrl()).isNotNull().isEqualTo("www.mk.com");
    }

    @Test
    public void deleteShouldRemoveData(){
        Aplication aplication = new Aplication(1L , "MKSolutions", "www.mk.com", true, "www.img.com");
        this.aplicationRepository.save(aplication);
        aplicationRepository.delete(aplication);
        assertThat(aplicationRepository.findById(aplication.getId())).isNull();
    }
}
