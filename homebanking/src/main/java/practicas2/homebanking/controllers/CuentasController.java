package practicas2.homebanking.controllers;

import org.springframework.web.bind.annotation.*;
import practicas2.homebanking.exceptions.CuentaNotFoundException;
import practicas2.homebanking.repositories.CuentasRepository;
import practicas2.homebanking.models.Cuentas;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentasController {

    private final CuentasRepository cuentaRepository;

    public CuentasController(CuentasRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
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

    @PostMapping("")
    void crearCuenta(){
        
    }

}
