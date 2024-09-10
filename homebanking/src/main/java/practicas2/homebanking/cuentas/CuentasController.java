package practicas2.homebanking.cuentas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import practicas2.homebanking.clientes.ClientesRepository;

public class CuentasController {

    private final CuentasRepository cuentaRepository;

    public CuentasController(CuentasRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }

    @Bean
    public CommandLineRunner initData(ClientesRepository clienteRepository) {
        return (args) -> {
            if(cuentaRepository.findAll().isEmpty()){
                Cuentas cuenta = new Cuentas("C1",10000);
                cuentaRepository.save(cuenta);
            }
        };
    }
}
