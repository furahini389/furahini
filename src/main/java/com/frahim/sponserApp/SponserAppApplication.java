package com.frahim.sponserApp;

import com.frahim.sponserApp.entity.SponserEntity;
import com.frahim.sponserApp.repository.SponserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SponserAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SponserAppApplication.class, args);
	}

	@Autowired
	private SponserRepository sponserRepository;
	@Override
	public void run(String... args) throws Exception {
		SponserEntity sponserEntity = new SponserEntity();
		sponserEntity.setExpertise("Professional");
		sponserEntity.setBrandAlignment("jsaktg");
		sponserEntity.setEthicalValue("High");
		sponserEntity.setNetwork("gjdka");
		sponserEntity.setReputation("En");
		sponserEntity.setFinancial_resources("Available");
		sponserRepository.save(sponserEntity);

	}
}
