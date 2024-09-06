package practicas2.homebanking.clientes;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
// con esta anotacion le digo a spring que lo trate como un bean
// un bean es una instancia de una clase con metadata. El bean entonces es un objeto que el
// "SpringContainer" esta manejando para nosotros
// Spring utiliza este bean cuando es instanciado para "inyectarlo" (dependency injection) en mi clase ClientesController
// a partir del constructor

// este es un repositorio sino nunca va a estar
// enterado de que existe la clase ClientesRepository para usar el metodo init para el post
public class ClientesRepository {
    private List<Clientes> clientes = new ArrayList<>();

    List<Clientes> getClientes(){
        return clientes;
    }

    void crearCliente(Clientes clienteNuevo){
        clientes.add(clienteNuevo);
    }

    Optional<Clientes> filtrarPorId(Integer parametroId){

        // un Optional es un contenedor de objeto que puede o no contener un valor no null
        // isPresent() sirve para evaluar y arroja true o fale si es el valor es o no null,
        // si es false es porque esta vacio
        Optional<Clientes> clienteFiltrado = Optional.ofNullable(clientes.get(parametroId));


        return clienteFiltrado;
    }

    @PostConstruct
    // utilizado en un metodo despues de haberse realizado 'dependency injection'
    // dependency injection: en lugar de que una clase tenga sus propias
    // dependencias al ser instanciada (con new), las dependencias se pasan como parametro con el
    // constructor de la clase

    // la dependency injection se utiliza para decoupling o sea, desarmar en partes mas pequeñas el comportamiento
    // de nuestra aplicacion para que sea más fácil entenderla y mantenerla
    // en este caso, la clase ClientesController no necesita saber COMO crear un ClientesRepository, solo lo recibe (dependency injection)
    private void init(){
        // instancio y agrego al mismo tiempo a mi lista de clientes
        clientes.add(new Clientes(1, "Juan", "Fernandez"));

        clientes.add(new Clientes(2, "Julian", "Messi"));
    }

    void actualizarCliente(@RequestBody Clientes cliente, @PathVariable Integer id){

        // creo variable optional por si viene null y lo filtro con mi metodo filtrar por id para
        // encontrar el cliente
        Optional<Clientes> clienteEncontrado = filtrarPorId(id);


        if(clienteEncontrado.isPresent()){
            // si el cliente esta en el optional uso get para obtener su valor,
            // uso set para reemplazar el cliente encontrado (primero busco su index con indexOf)
            // y reemplazo el cliente en el index especificado con el cliente que viene por parametro

            clientes.set(clientes.indexOf(clienteEncontrado.get()), cliente);
        }
    }

    void eliminarCliente(@PathVariable Integer id){
        Optional<Clientes> clienteEncontrado = filtrarPorId(id);
        if(clienteEncontrado.isPresent()){
            clientes.remove(clientes.indexOf(clienteEncontrado.get()));
        }


    }
}
