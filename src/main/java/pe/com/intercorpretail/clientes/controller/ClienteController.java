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
import pe.com.intercorpretail.clientes.service.ClienteService;
import pe.com.intrecorpretail.response.Response;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Crear nuevo cliente",response=String.class)
    @PostMapping(value = "/creacliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> crearClientes(@RequestBody ClienteDto clienteDto){
    	this.clienteService.insertCliente(clienteDto);
        return  new ResponseEntity<String>("Se inserto correctamente", HttpStatus.OK);
    }
    
    @ApiOperation(value = "Promedio de edad entre todos los clientes",response=String.class)
    @GetMapping(value = "/kpideclientes")
    @ResponseBody
    public ResponseEntity<String> kpiClientes(){
    	Map<String, Double> retorno = this.clienteService.mediaDesviacionClientes();
        return new ResponseEntity<String>("El promediio de edad de los clientes es: "+retorno.get("media") 
        								+ "La desviacion estandar es: " + retorno.get("desviacion"),
        		HttpStatus.OK);
    }
    
    @ApiOperation(value = "Lista de personas con todos los datos",response=Response.class)
    @GetMapping(value = "/listclientes")
    @ResponseBody
    public ResponseEntity<Response> listClientes(){
    	List<ClienteDto> retorno = this.clienteService.listClientes();
        return new ResponseEntity<>(new Response(HttpStatus.OK.toString(),"Ok",retorno),HttpStatus.OK);
    }
    
}
