package pe.com.intercorpretail.clientes.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {


    @GetMapping(value = "/creacliente")
    public String obtenerHolaMunto(){
        return "Hola Mundo";
    }
}
