package br.com.codenation.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.codenation.hospital.domain.MedicalProcedure;

public interface MedicalProcedureRepository extends MongoRepository<MedicalProcedure, Long>{

}
