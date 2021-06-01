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

import co.edu.usbbog.bdd.model.Transaccion;
import co.edu.usbbog.bdd.repo.TransaccionRepository;


@RestController
@RequestMapping("/Transaccion")
public class TransaccionControler {
	
	@Autowired
	private TransaccionRepository cmet;

	@PostMapping("/create") 
	public String insertTransaccion(@RequestBody Transaccion c) {
		try {
			if (cmet.existsById(c.getId())) {
				return "Ya se encuentra registrada Transaccion";
			} else {
				cmet.save(c);
				return "Tipo Transaccion se Registro exitosamente";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo: " + e.getMessage();
		}
	}
	
	
	@GetMapping("/all")
	public List<Transaccion>findAllTransaccion() {
		List<Transaccion> l = cmet.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay Transaccion");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{id}")
	public Optional<Transaccion> findTransaccion(@PathVariable("id") Long id) {
		Optional<Transaccion> cu =  cmet.findById(id);
		if (!cu.equals(null)) {
			return cu;
		} else {
            throw new RuntimeException(" no encontrado");
		}	
	}
	
	@GetMapping("/count")
	public long contarTransaccion() {
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
	public String eliminarTransaccion(@RequestBody Transaccion cuenta) {
		try {
			if (cmet.existsById(cuenta.getId())) {
				cmet.deleteById(cuenta.getId());
				return "Se ha eliminado correctamente";
			} else {
				return "Transaccion no se encuentra registrada";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino la Transaccion: " + e.getMessage();
		}
	}
	
	@PutMapping("/update")
	public String updateTransaccion(@RequestBody Transaccion c) {
		Optional<Transaccion> ci = cmet.findById(c.getId());
		if (ci.equals(null)) {
            throw new RuntimeException("Transaccion no encontrada");
		} else {
			cmet.save(c);
			return "la Transaccion se actualizo";

		}
		
	}
}
