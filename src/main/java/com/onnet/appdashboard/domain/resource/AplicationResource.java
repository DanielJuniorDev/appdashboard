package com.onnet.appdashboard.domain.resource;

import com.onnet.appdashboard.domain.model.Aplication;
import com.onnet.appdashboard.domain.repository.AplicationRepository;
import com.onnet.appdashboard.domain.service.AplicationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/api/aplication")
public class AplicationResource {

    @Autowired
    private AplicationRepository aplicationRepository;

    @Autowired
    private AplicationService aplicationService;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add")
    public ResponseEntity<Aplication> addAplicatino(@RequestBody Aplication aplication){
        return aplicationService.addAplication(aplication);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Aplication>> getAplications(){
        List<Aplication> aplications = aplicationService.getAllAplication();
        if(aplications.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Aplication>>(aplications, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aplication> getAplication(@PathVariable("id") long id){
        return aplicationService.getAplication(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aplication> updateAplication(@PathVariable("id") long id, @RequestBody Aplication aplication){
        return aplicationService.updateAplication(id, aplication);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Aplication> deleteAplication(@PathVariable("id") long id){
       return aplicationService.deleteAplication(id);
    }


}
