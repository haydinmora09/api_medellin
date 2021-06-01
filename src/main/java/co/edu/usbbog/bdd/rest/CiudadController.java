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
import co.edu.usbbog.bdd.model.Ciudad;
import co.edu.usbbog.bdd.repo.CiudadRepository;



@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private CiudadRepository cmet;
	

	@PostMapping("/create")
	public String insertCiudad(@RequestBody Ciudad c) {	
		try {
			if (cmet.existsById(c.getId())) {
				return "Ya se encuentra registrada la ciudad";
			} else {
				cmet.save(c);
				return "La ciudad se Registro exitosamente";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo: " + e.getMessage();
		}
	}
	
	@GetMapping("/all")
	public List<Ciudad>buscarCiudades() {
		List<Ciudad> cm = cmet.findAll();
		if (cm.isEmpty() || cm.equals(null)) {
			throw new RuntimeException("No hay ciudades registradas");
		} else {
			return cm;
		}
		
	}
	
	@GetMapping("/find")
	public Optional<Ciudad> findCiudad(@PathVariable("id") long id) {
		Optional<Ciudad> ci = cmet.findById(id);
		if (ci.equals(null)) {
			throw new RuntimeException("Ciudad identificada con el ID: "+id+" no encontrado");
		} else {
			
			return ci;
		}
	}
	
	
	@GetMapping("/count")
	public long contarCiudades() {
		long c = cmet.count();
		try {
			if (c != 0) {
				return c;
		
			}else {
				 throw new RuntimeException("No hay ciudades ");
			}
		} catch (IllegalArgumentException e) {
			return c;
		}
	}
			
	@DeleteMapping("/eliminar")
	public String eliminarCiudad(@RequestBody Ciudad ciudad) {
		try {
			if (cmet.existsById(ciudad.getId())) {
				cmet.deleteById(ciudad.getId());
				return "Se ha eliminado correctamente";
			} else {
				return "La ciudad no se encuentra registrada";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino la ciudad: " + e.getMessage();
		}
	}
	@PutMapping("/update")
	public String updateCiudad(@RequestBody Ciudad c) {
		Optional<Ciudad> ci = cmet.findById(c.getId());
		if (ci.equals(null)) {
            throw new RuntimeException("Ciudad no encontrada");
		} else {
			cmet.save(c);
			return "la ciudad se actualizo";

		}
		
	}
}