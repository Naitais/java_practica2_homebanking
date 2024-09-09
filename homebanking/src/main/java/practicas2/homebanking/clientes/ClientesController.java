package practicas2.homebanking.clientes;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return clientesRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Clientes> buscarClientePorId(@PathVariable Integer id){
        Optional<Clientes> clienteFiltrado = clientesRepository.findById(id);
        if (clienteFiltrado.isEmpty()){

            throw new ClienteNotFoundException();

        }

        return clienteFiltrado;
    }


    //uso RequestBody porque los datos vienen a partir de un input
    @ResponseStatus(HttpStatus.CREATED) // para tener una respuesta despues de haber creado el post
    @PostMapping("") //vacio porque asi comparte la misma ruta que los demas
    void crearCliente(@RequestBody Clientes cliente){

        clientesRepository.save(cliente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void actualizarCliente(@RequestBody Clientes cliente, @PathVariable Integer id){
        cliente.setId(id);
        clientesRepository.save(cliente);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarCliente(@PathVariable Integer id){

        clientesRepository.deleteById(id);
    }

    @Bean
    public CommandLineRunner initData(ClientesRepository clienteRepository) {
        return (args) -> {
            if(clienteRepository.findAll().isEmpty()){
                Clientes cliente = new Clientes("Miguel", "Rejas", "rejas@gmail.com");
                clienteRepository.save(cliente);
            }
        };
    }
}


