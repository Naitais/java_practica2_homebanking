package practicas2.homebanking.controllers;

import org.springframework.web.bind.annotation.*;
import practicas2.homebanking.exceptions.ClienteNotFoundException;
import practicas2.homebanking.exceptions.CuentaNotFoundException;
import practicas2.homebanking.models.Clientes;
import practicas2.homebanking.repositories.ClientesRepository;
import practicas2.homebanking.repositories.CuentasRepository;
import practicas2.homebanking.models.Cuentas;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentasController {

    private final CuentasRepository cuentaRepository;
    private final ClientesRepository clientesRepository;

    public CuentasController(CuentasRepository cuentaRepository, ClientesRepository clientesRepository) {
        this.cuentaRepository = cuentaRepository;
        this.clientesRepository = clientesRepository;
    }


    @GetMapping("")
    List<Cuentas> listadoCuentas(){
        return cuentaRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Cuentas> buscarCuentaPorId(@PathVariable Integer id){
        Optional<Cuentas> cuentaFiltrado = cuentaRepository.findById(id);
        if (cuentaFiltrado.isEmpty()){

            throw new CuentaNotFoundException();

        }

        return cuentaFiltrado;
    }

    @PostMapping("/{id}")
    void crearCuenta(@PathVariable Integer id,@RequestBody Cuentas cuenta){

        //busco por id cliente al cual le agrego la cuenta
        Optional<Clientes> clienteFiltrado = clientesRepository.findById(id);
        if (clienteFiltrado.isEmpty()){

            throw new ClienteNotFoundException();

        }

        //lo saco del optional con get y agrego la cuenta
        clienteFiltrado.get().agregarCuenta(cuenta);
        //guardo la cuenta en la base de datos
        cuentaRepository.save(cuenta);


    }

}
