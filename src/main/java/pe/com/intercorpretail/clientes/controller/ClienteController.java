package pe.com.intercorpretail.clientes.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.intercorpretail.clientes.dto.ClienteDto;
import pe.com.intercorpretail.clientes.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @ApiOperation(value = "Crear nuevo cliente",response=String.class)
    @GetMapping(value = "/creacliente")
    public String crearClientes(@RequestBody ClienteDto clienteDto){

        return "Hola Mundo";
    }
}
