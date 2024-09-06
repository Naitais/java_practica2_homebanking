package practicas2.homebanking.clientes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(){
        super("Cliente no encontrado.");
    }


}
