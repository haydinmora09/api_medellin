package co.edu.usbbog.bdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
	
}
