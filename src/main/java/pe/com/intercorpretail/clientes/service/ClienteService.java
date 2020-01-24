package pe.com.intercorpretail.clientes.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public Map<String, Double> mediaDesviacionClientes(){
    	List<ClienteDao> clienteDao = new ArrayList<ClienteDao>();
    	clienteDao = this.clienteRepository.findAll();
    	return variacionEstandar(clienteDao);
    }
    
    public Map<String, Double> variacionEstandar(List<ClienteDao> clienteDao) {
    	double varianza = 0.0;
    	double desviacion= 0.0;
    	double totalMuestra= clienteDao.size() -1;
    	double media = (clienteDao.stream().mapToInt(s -> s.getEdad()).sum())/clienteDao.size();
    	 Map<String, Double> retorno = new HashMap<String, Double>();
    	
    	for(ClienteDao cdao : clienteDao){
    		   double rango;
    		   rango = Math.pow(cdao.getEdad() - media, 2f);
    		   varianza = varianza + rango;
    		  }
    		  varianza = varianza / totalMuestra;
    		  desviacion = Math.sqrt(varianza);
    		  
    		  retorno.put("media", media);
    		  retorno.put("desviacion", desviacion);
    		  
    		return retorno;  
    }
    
    
    public List<ClienteDto> listClientes(){
    	List<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
    	List<ClienteDao> clientes = this.clienteRepository.findAll();
    	ClienteDto dto = null;
    	for(ClienteDao dao : clientes) {
    		dto = new ClienteDto();
    		dto.setNombre(dao.getNombre());
    		dto.setApellido(dao.getApellido());
    		dto.setEdad(dao.getEdad());
    		dto.setFechaNacimiento(dao.getFechaNacimiento());
    		listaClientes.add(dto);
    	}
    	return listaClientes;
    }
    
    
}
