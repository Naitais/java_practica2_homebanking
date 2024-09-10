package practicas2.homebanking.cuentas;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import practicas2.homebanking.clientes.Clientes;

import java.time.LocalDate;

@Entity
public class Cuentas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String numero;
    private LocalDate fechaCreacion;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;


    public Cuentas(String numero, double saldo) {
        this.numero = numero;
        this.fechaCreacion = LocalDate.now();
        this.saldo = saldo;
    }

    public Cuentas(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }


}
