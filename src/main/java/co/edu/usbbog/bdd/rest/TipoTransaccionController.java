package co.edu.usbbog.bdd.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.TipoTransaccion;
import co.edu.usbbog.bdd.repo.TipoTransaccionRepository;


@RestController
@RequestMapping("/TipoTransaccion")
public class TipoTransaccionController {
	
	@Autowired
	private TipoTransaccionRepository cmet;

	@PostMapping("/create") 
	public String insertTipoTransaccion(@RequestBody TipoTransaccion c) {
		try {
			if (cmet.existsById(c.getId())) {
				return "Ya se encuentra registrada TipoTransaccion";
			} else {
				cmet.save(c);
				return "Tipo Transaccion se Registro exitosamente";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo: " + e.getMessage();
		}
	}
	
	
	@GetMapping("/all")
	public List<TipoTransaccion>findAllTipoTransaccion() {
		List<TipoTransaccion> l = cmet.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay TipoTransaccion");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{id}")
	public Optional<TipoTransaccion> findTipoTransaccion(@PathVariable("id") Long id) {
		Optional<TipoTransaccion> cu =  cmet.findById(id);
		if (!cu.equals(null)) {
			return cu;
		} else {
            throw new RuntimeException(" no encontrado");
		}	
	}
	
	@GetMapping("/count")
	public long contarTipoTransaccion() {
		long c =  cmet.count();
		try {
		if (c != 0) {
			return c;
		} else {
            throw new RuntimeException("No hay  registradas");
			}
		} catch (IllegalArgumentException e) {
			return c;
		}
	}
	@DeleteMapping("/eliminar")
	public String eliminarTipoTransaccion(@RequestBody TipoTransaccion cuenta) {
		try {
			if (cmet.existsById(cuenta.getId())) {
				cmet.deleteById(cuenta.getId());
				return "Se ha eliminado correctamente";
			} else {
				return "TipoTransaccion no se encuentra registrada";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino la TipoTransaccion: " + e.getMessage();
		}
	}
	
	@PutMapping("/update")
	public String updateTipoTransaccion(@RequestBody TipoTransaccion c) {
		Optional<TipoTransaccion> ci = cmet.findById(c.getId());
		if (ci.equals(null)) {
            throw new RuntimeException("TipoTransaccionno encontrada");
		} else {
			cmet.save(c);
			return "la TipoTransaccion se actualizo";

		}
		
	}
}