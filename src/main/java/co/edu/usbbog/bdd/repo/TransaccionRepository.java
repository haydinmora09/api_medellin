package co.edu.usbbog.bdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbbog.bdd.model.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion,Long > {

}
