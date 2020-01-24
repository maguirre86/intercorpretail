package pe.com.intercorpretail.clientes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.intercorpretail.clientes.dao.ClienteDao;
import pe.com.intercorpretail.clientes.dto.ClienteDto;
import pe.com.intercorpretail.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void insertCliente(ClienteDto clienteDto){
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.setNombre(clienteDto.getNombre());
        clienteDao.setApellido(clienteDto.getApellido());
        clienteDao.setEdad(clienteDto.getEdad());
        clienteDao.setFechaNacimiento(clienteDto.getFechaNacimiento());
        clienteRepository.save(clienteDao);
    }
    
    public Integer promedioClientes(){
    	List<ClienteDao> clienteDao = new ArrayList<ClienteDao>();
    	clienteDao = this.clienteRepository.findAll();
    	int suma = clienteDao.stream()
        .mapToInt(s -> s.getEdad())
        .sum();
    	
    	return (suma/clienteDao.size());
    	
    }
}
