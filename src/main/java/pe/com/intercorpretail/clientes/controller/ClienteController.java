package pe.com.intercorpretail.clientes.controller;


import io.swagger.annotations.ApiOperation;
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

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Crear nuevo cliente",response=String.class)
    @PostMapping(value = "/creacliente", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String crearClientes(@RequestBody ClienteDto clienteDto){
    	this.clienteService.insertCliente(clienteDto);
        return "Se inserto correctamente";
    }
    
    @ApiOperation(value = "Promedio de edad entre todos los clientes",response=String.class)
    @GetMapping(value = "/kpideclientes")
    @ResponseBody
    public ResponseEntity<String> kpiClientes(){
        return new ResponseEntity<String>("El promediio de edad de los clientes es: "+this.clienteService.promedioClientes(),
        		HttpStatus.OK);
    }
    
}
