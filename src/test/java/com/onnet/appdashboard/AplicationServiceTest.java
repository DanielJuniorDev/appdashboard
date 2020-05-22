package com.onnet.appdashboard;

import com.onnet.appdashboard.domain.model.Aplication;
import com.onnet.appdashboard.domain.repository.AplicationRepository;
import com.onnet.appdashboard.domain.service.AplicationService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AplicationServiceTest {

    @InjectMocks
    private AplicationRepository aplicationRepository;


    @Test
    public void getAllAplications(){
        List<Aplication> aplications = Arrays.asList(new Aplication(1L , "Mk Dash", "www.img.com", true, "www.imggur.com.br"));

        Mockito.when(aplicationRepository.findAll())
                .thenReturn(aplications);
    }

}
