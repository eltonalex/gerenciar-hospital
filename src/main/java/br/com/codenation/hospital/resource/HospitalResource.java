package br.com.codenation.hospital.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.hospital.domain.Hospital;
import br.com.codenation.hospital.domain.Patient;
import br.com.codenation.hospital.domain.Product;
import br.com.codenation.hospital.dto.HospitalDTO;
import br.com.codenation.hospital.services.HospitalService;


@RestController
@RequestMapping(path = "/")
public class HospitalResource {
	
	@Autowired
	private HospitalService service;
	
	@GetMapping("/v1/hospitais")
	public ResponseEntity<List<HospitalDTO>> findAll(){
		List<Hospital> list = service.findAll();
		List<HospitalDTO> listDTO = list.stream().map(x -> new HospitalDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/v1/hospitais/{id}")
	public ResponseEntity<HospitalDTO> findById(@PathVariable String id){
		Hospital obj = service.findById(id);
		return ResponseEntity.ok().body(new HospitalDTO(obj));
	}
	
	@PostMapping("/v1/hospitais")
	public ResponseEntity<HospitalDTO> insert(@RequestBody HospitalDTO objDTO){
		Hospital obj = service.fromDTO(objDTO);
		obj = service.insert(obj);

		return ResponseEntity.ok().body(new HospitalDTO(obj));
	}
	
	@DeleteMapping("/v1/hospitais/{id}")
	public ResponseEntity<String> deleteById(@PathVariable String id){
		service.delete(id);

		return ResponseEntity.ok().body("hospital apagado: " + id);
	}
	
	@PutMapping("/v1/hospitais/{id}")
	public ResponseEntity<HospitalDTO> update(@RequestBody HospitalDTO objDTO, @PathVariable String id){
		Hospital obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.ok().body(new HospitalDTO(obj));
	}
	
	@GetMapping("/v1/hospitais/{id}/pacientes")
	public ResponseEntity<List<Patient>> findByPatients(@PathVariable String id){
		Hospital obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPatients());
	}
	
	@GetMapping("/v1/hospitais/{id}/estoque")
	public ResponseEntity<List<Product>> findByProducts(@PathVariable String id){
		Hospital obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getProducts());
	}
}