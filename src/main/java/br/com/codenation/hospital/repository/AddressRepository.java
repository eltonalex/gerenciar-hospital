package br.com.codenation.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.codenation.hospital.domain.Address;

public interface AddressRepository extends MongoRepository<Address, Long>{

}
