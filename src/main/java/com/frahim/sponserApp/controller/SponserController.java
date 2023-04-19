package com.frahim.sponserApp.controller;

import com.frahim.sponserApp.entity.SponserEntity;
import com.frahim.sponserApp.exception.SponserException;
import com.frahim.sponserApp.repository.SponserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sponserInfo")
public class SponserController {

    @Autowired
    private SponserRepository sponserRepository;

    //code for getting all sponser
    @GetMapping
    public List<SponserEntity> getAllSponser(SponserEntity sponserEntity){
        return sponserRepository.findAll();
    }

    //code for adding/create sponser
    @PostMapping
    public SponserEntity createSponser(@RequestBody SponserEntity sponserEntity){
        return sponserRepository.save(sponserEntity);
    }

    //Code for reading or getting sponser
    @GetMapping("{}")
    public ResponseEntity<SponserEntity> getSponserById(@PathVariable long id){
        SponserEntity sponserEntity = sponserRepository.findById(id)
                .orElseThrow(()->new SponserException("Sponser not found"));
        return ResponseEntity.ok(sponserEntity);
    }

    //Code for updating sponser
    @PutMapping("{id}")
    public ResponseEntity<SponserEntity> updateSponser(@PathVariable long id,@RequestBody SponserEntity sponserEntityDetails){
        SponserEntity updateSponser = sponserRepository.findById(id)
                .orElseThrow(()->new SponserException("Sponser not found"));

        updateSponser.setFinancial_resources(sponserEntityDetails.getFinancial_resources());
        updateSponser.setReputation(sponserEntityDetails.getReputation());
        updateSponser.setNetwork(sponserEntityDetails.getNetwork());
        updateSponser.setExpertise(sponserEntityDetails.getExpertise());
        updateSponser.setEthicalValue(sponserEntityDetails.getEthicalValue());
        updateSponser.setBrandAlignment(sponserEntityDetails.getBrandAlignment());

        sponserRepository.save(updateSponser);
        return ResponseEntity.ok(updateSponser);
    }

    //Code for deleting sponser
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSponser(@PathVariable long id){
        SponserEntity deleteSponser = sponserRepository.findById(id)
                .orElseThrow(()->new SponserException("Sponser Not found"));

        sponserRepository.delete(deleteSponser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
