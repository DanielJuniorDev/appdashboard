package com.onnet.appdashboard;

import com.onnet.appdashboard.domain.model.Aplication;
import com.onnet.appdashboard.domain.repository.AplicationRepository;
import com.onnet.appdashboard.domain.service.AplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AplicationResourceTest {


    @Autowired
    private AplicationRepository aplicationRepository;

    @Test
    public  void findAllUser(){
        List<Aplication> aplications = aplicationRepository.findAll();
        assertThat(aplications).isNotNull();
    }


}
