package practicas2.homebanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practicas2.homebanking.models.Cuentas;

public interface CuentasRepository extends JpaRepository<Cuentas, Integer> {
}
