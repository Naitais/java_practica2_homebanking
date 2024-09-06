package practicas2.homebanking.clientes;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

// annotations agrega comportamiento a las clases
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClientesRepository clientesRepository;

    public ClientesController(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("")
    List<Clientes> listadoClientes(){
        return clientesRepository.getClientes();
    }

    @GetMapping("/{id}")
    Optional<Clientes> clientePorId(@PathVariable Integer id){
        Optional<Clientes> clienteFiltrado = clientesRepository.filtrarPorId(id);
        if (clienteFiltrado.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente con id "+id+" no encontrado.");

        }

        return clienteFiltrado;
    }
    //uso RequestBody porque los datos vienen a partir de un input
    void crearCliente(@RequestBody Clientes cliente){
        clientesRepository.crearCliente(cliente);
    }

}


