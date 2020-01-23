package pe.com.intercorpretail.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.com.intercorpretail.clientes.dao.ClienteDao;
import pe.com.intercorpretail.clientes.dto.ClienteDto;
import pe.com.intercorpretail.clientes.repository.ClienteRepository;

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
}
