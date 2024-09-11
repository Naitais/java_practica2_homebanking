package practicas2.homebanking.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    // Relaciono mi entidad cliente con cuentas:

    // mappedBy = "cliente" -> significa que la entidad cuentas va a tener una clave foranea cliente

    // cascade = CascadeType.ALL -> significa que cualquier modificacion que afecte a clientes afecta
    // a todas las cuentas asociadas
    /*
    * PERSIST: When the parent entity is persisted (saved), the child entities are also persisted.
      MERGE: When the parent entity is merged (updated), the child entities are also merged.
      REMOVE: When the parent entity is removed (deleted), the child entities are also removed.
      REFRESH: When the parent entity is refreshed, the child entities are also refreshed.
      DETACH: When the parent entity is detached from the persistence context, the child entities are also detached.
      ALL: This is shorthand for applying all the above operations (i.e., persist, merge, remove, refresh, detach).
    * */

    //fetch = FetchType.LAZY -> significa que los datos de la cuenta asociada se buscan o cargan
    // solo cuando se acceden via codigo. Además de LAZY esta EAGER que hace que se carguen inmediatamente
    // dependiendo del caso usar LAZY ayuda a la performance porque no carga de forma innecesaria

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuentas> cuentas = new ArrayList<Cuentas>();

    public Clientes(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public Clientes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public void agregarCuenta(Cuentas cuenta){
        cuenta.setCliente(this);
        cuentas.add(cuenta);
    }
}
