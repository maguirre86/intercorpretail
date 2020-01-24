package pe.com.intercorpretail.clientes.controller;


import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.intercorpretail.clientes.dto.ClienteDto;
import pe.com.intercorpretail.clientes.dto.PromedioDesvicionDto;
import pe.com.intercorpretail.clientes.service.ClienteService;
import pe.com.intrecorpretail.response.Response;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Crear nuevo cliente",response=Response.class)
    @PostMapping(value = "/creacliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Response> crearClientes(@RequestBody ClienteDto clienteDto){
    	ResponseEntity<Response> payload = null;
      try {	
    	this.clienteService.insertCliente(clienteDto);
    	payload = new ResponseEntity<>(new Response(HttpStatus.OK.toString(),"Ok","Se inserto correctamente"),HttpStatus.OK);
      }catch(Exception e){
    	  payload = new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"ERROR","Ocurriio un error interno"),HttpStatus.INTERNAL_SERVER_ERROR);
      }  
      return payload;
    }
    
    @ApiOperation(value = "Promedio de edad entre todos los clientes",response=Response.class)
    @GetMapping(value = "/kpideclientes")
    @ResponseBody
    public ResponseEntity<Response> kpiClientes(){
    	ResponseEntity<Response> payload = null;
      try {	
    	Map<String, Double> retorno = this.clienteService.mediaDesviacionClientes();
    	PromedioDesvicionDto promedioDesviacion = new PromedioDesvicionDto();
    	promedioDesviacion.setDesviacion(retorno.get("desviacion"));
    	promedioDesviacion.setPromedio(retorno.get("media"));
        payload =  new ResponseEntity<>(new Response(HttpStatus.OK.toString(),"Ok",retorno),HttpStatus.OK);
      }catch(Exception e){
    	  payload = new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"ERROR","Ocurriio un error interno"),HttpStatus.INTERNAL_SERVER_ERROR);
      }  
      return payload;  
    }
    
    @ApiOperation(value = "Lista de personas con todos los datos",response=Response.class)
    @GetMapping(value = "/listclientes")
    @ResponseBody
    public ResponseEntity<Response> listClientes(){
    	ResponseEntity<Response> payload = null;
    	try {
	    	List<ClienteDto> retorno = this.clienteService.listClientes();
	        payload =  new ResponseEntity<>(new Response(HttpStatus.OK.toString(),"Ok",retorno),HttpStatus.OK);
    	}catch(Exception e){
      	  payload = new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"ERROR","Ocurriio un error interno"),HttpStatus.INTERNAL_SERVER_ERROR);
        }  
        return payload;      
    }
    
}
