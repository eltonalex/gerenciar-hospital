package br.com.codenation.hospital.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.codenation.hospital.domain.Warehouse;

public interface WarehouseRepository extends MongoRepository<Warehouse, Long>{

}
