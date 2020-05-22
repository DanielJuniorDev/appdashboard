package com.onnet.appdashboard.domain.service;

import com.onnet.appdashboard.domain.model.Aplication;
import com.onnet.appdashboard.domain.repository.AplicationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;

@Service
public class AplicationService {

    @Autowired
    private AplicationRepository aplicationRepository;

    public ResponseEntity<Aplication> addAplication(Aplication aplication){
        Aplication newAplication = aplicationRepository.save(aplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAplication);
    }

    public List<Aplication> getAllAplication(){
        List<Aplication> aplications = aplicationRepository.findAll();
        if(aplications.isEmpty()){
            return null;
        }
        return aplications;
    }

    public ResponseEntity<Aplication> getAplication(long id){
        Aplication aplication = aplicationRepository.findById(id).orElse(null );
        if(aplication == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Aplication>(aplication, HttpStatus.OK);
    }

    public ResponseEntity<Aplication> updateAplication(long id , Aplication aplication){
        Aplication updateAplication = aplicationRepository.findById(id).orElse(null);
        if(updateAplication == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(aplication, updateAplication, "id");
        aplicationRepository.save(updateAplication);
        return new ResponseEntity<Aplication>(updateAplication, HttpStatus.OK);
    }

    public ResponseEntity<Aplication> deleteAplication(long id){
        Aplication aplication = aplicationRepository.findById(id).orElse(null);
        if(aplication == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        aplicationRepository.delete(aplication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
