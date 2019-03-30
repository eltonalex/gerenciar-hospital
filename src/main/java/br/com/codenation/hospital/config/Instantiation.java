package br.com.codenation.hospital.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.codenation.hospital.domain.Address;
import br.com.codenation.hospital.domain.Hospital;
import br.com.codenation.hospital.domain.Patient;
import br.com.codenation.hospital.domain.Product;
import br.com.codenation.hospital.domain.Warehouse;
import br.com.codenation.hospital.dto.AddressDTO;
import br.com.codenation.hospital.dto.HospitalDTO;
import br.com.codenation.hospital.dto.ProductDTO;
import br.com.codenation.hospital.dto.WarehouseDTO;
import br.com.codenation.hospital.repository.AddressRepository;
import br.com.codenation.hospital.repository.HospitalRepository;
import br.com.codenation.hospital.repository.MedicalProcedureRepository;
import br.com.codenation.hospital.repository.PatientRepository;
import br.com.codenation.hospital.repository.ProductRepository;
import br.com.codenation.hospital.repository.WarehouseRepository;

//Operação de instanciação da base de dados

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private MedicalProcedureRepository medicalProcedureRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		hospitalRepository.deleteAll(); //deleta todos dados do mongodb
		patientRepository.deleteAll();
		productRepository.deleteAll();
		addressRepository.deleteAll();
		warehouseRepository.deleteAll();
		medicalProcedureRepository.deleteAll();
		
		Address address1 = new Address("Rua dos Sonhos", "1213", "Centro", "Estado1");
		Address address2 = new Address("Rua da Arte", "2113", "Bairro", "Estado2");
		Address address3 = new Address("Rua da Vida", "3213", "Jardim", "Estado3");
		Address address4 = new Address("Avenida dos Sonhos", "213", "Bairro", "Estado1");
		
		addressRepository.saveAll(Arrays.asList(address1,address2,address3, address4));//adiciona dados
		
		Hospital hospitalUm = new Hospital("1", "Hospital Um", new AddressDTO(address1), 21,5);
		Hospital hospitalDois = new Hospital("2", "Hospital Dois",  new AddressDTO(address2), 11,6);
		Hospital hospitalTres = new Hospital("3", "Hospital Tres",  new AddressDTO(address3), 32,12);
		Hospital hospitalQuatro = new Hospital("3", "Hospital Quatro",  new AddressDTO(address4), 32,12);
		
		hospitalRepository.saveAll(Arrays.asList(hospitalUm,hospitalDois,hospitalTres, hospitalQuatro)); //adiciona dados
		
		Patient pacient1 = new Patient(null, "Maria", "864789205", sdf.parse("16/07/2003"), "feminino", sdf.parse("16/07/2019"),new HospitalDTO(hospitalUm));
		Patient pacient2 = new Patient(null, "Pedro", "864789205", sdf.parse("16/07/2003"), "masculino", sdf.parse("16/07/2019"),new HospitalDTO(hospitalUm));
		Patient pacient3 = new Patient(null, "Joana", "864789205", sdf.parse("16/07/2003"), "feminino", sdf.parse("16/07/2019"),new HospitalDTO(hospitalTres));
		
		patientRepository.saveAll(Arrays.asList(pacient1,pacient2,pacient3));
		
		
		Warehouse warehouse1 = new Warehouse("Estoque 1", "Estoque Medicamentos", new AddressDTO(address1));
		Warehouse warehouse2 = new Warehouse("Estoque 2", "Banco de Orgãos", new AddressDTO(address2));
		Warehouse warehouse3 = new Warehouse("Estoque 3", "Banco de Sangue", new AddressDTO(address3));
		
		warehouseRepository.saveAll(Arrays.asList(warehouse1, warehouse2, warehouse3));
		
		
		Product produto1 = new Product(null, "medicamento", "Paracetamol", 12, new ProductDTO(hospitalDois), new WarehouseDTO(warehouse1) );
		Product produto2 = new Product(null, "medicamento", "Soro glicosado", 3, new ProductDTO(hospitalTres), new WarehouseDTO(warehouse1));
		Product produto3 = new Product(null, "Orgão Coração", "Coração", 2, new ProductDTO(hospitalTres), new WarehouseDTO(warehouse2));
		Product produto4 = new Product(null, "Bolsa Sangue A+", "Bolsa de Sangue A+", 15, new ProductDTO(hospitalTres), new WarehouseDTO(warehouse3));
		Product produto5 = new Product(null, "Bolsa Sangue B+", "Bolsa de Sangue B+", 25, new ProductDTO(hospitalTres), new WarehouseDTO(warehouse3));
		
		productRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4, produto5));
		
		//referenciando pacientes e produtos ao hospital
		hospitalUm.getPatients().addAll(Arrays.asList(pacient1,pacient2));
		hospitalTres.getPatients().addAll(Arrays.asList(pacient3));
		
		hospitalTres.getProducts().addAll(Arrays.asList(produto2,produto3,produto4));
		hospitalDois.getProducts().addAll(Arrays.asList(produto1));
		
		hospitalRepository.save(hospitalUm);
		hospitalRepository.save(hospitalDois);
		hospitalRepository.save(hospitalTres);
		hospitalRepository.save(hospitalQuatro);
		
		
		
	}
}