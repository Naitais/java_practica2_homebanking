package practicas2.homebanking.clientes;

// los records son immutables y no pueden ser cambiados una vez que se crean
// el record es implicitamente final, no puede ser heredado y sus atributos no pueden ser modificados
// con los records no hace falta crear getters porque ya vienen creados
// tambien viene con su propio equals(), hashcode() y tostring()
// (los setters tampoco se deben crear porque los records son immutables no pueden ser seteados)
// en conclusion sirven para ahorrar codigo boilerplate que siempre se genera cuando se crea una clase

public record ClientesRecord(
        Integer id,
        String nombre,
        String apellido


) {

}
