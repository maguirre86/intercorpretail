package pe.com.intercorpretail.clientes.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @ApiOperation(value = "Crear nuevo cliente",response=String.class)
    @GetMapping(value = "/creacliente")
    public String crearClientes(){
        return "Hola Mundo";
    }
}
