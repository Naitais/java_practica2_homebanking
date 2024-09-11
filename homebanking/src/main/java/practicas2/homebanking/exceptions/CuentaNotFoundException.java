package practicas2.homebanking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CuentaNotFoundException extends RuntimeException{
    public CuentaNotFoundException(){
        super("Cuenta no encontrado.");
    }


}
