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
import co.edu.usbbog.bdd.model.Cuenta;
import co.edu.usbbog.bdd.repo.CuentaRepository;


@RestController
@RequestMapping("/cuenta")
public class CuentaController {
	
	@Autowired
	private CuentaRepository cmet;

	@PostMapping("/create") 
	public String insertCuenta(@RequestBody Cuenta c) {
		try {
			if (cmet.existsById(c.getNum())) {
				return "Ya se encuentra registrada la cuenta";
			} else {
				cmet.save(c);
				return "La ciudad se Registro exitosamente";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo: " + e.getMessage();
		}
	}
	
	
	@GetMapping("/all")
	public List<Cuenta>findAllCuentas() {
		List<Cuenta> l = cmet.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay cuentas registradas");
		} else {
			return l;
		}
	}
	
	@GetMapping("/find/{num}")
	public Optional<Cuenta> findCuenta(@PathVariable("num") Long num) {
		Optional<Cuenta> cu =  cmet.findById(num);
		if (!cu.equals(null)) {
			return cu;
		} else {
            throw new RuntimeException("Cuenta identificada con el ID: "+num+" no encontrado");
		}	
	}
	
	@GetMapping("/count")
	public long coundCuenta() {
		long c =  cmet.count();
		try {
		if (c != 0) {
			return c;
		} else {
            throw new RuntimeException("No hay cuentas registradas");
			}
		} catch (IllegalArgumentException e) {
			return c;
		}
	}
	@DeleteMapping("/eliminar")
	public String eliminarCiudad(@RequestBody Cuenta cuenta) {
		try {
			if (cmet.existsById(cuenta.getNum())) {
				cmet.deleteById(cuenta.getNum());
				return "Se ha eliminado correctamente";
			} else {
				return "La cuenta no se encuentra registrada";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino la cuenta: " + e.getMessage();
		}
	}
	
	@PutMapping("/update")
	public String updateCiudad(@RequestBody Cuenta c) {
		Optional<Cuenta> ci = cmet.findById(c.getNum());
		if (ci.equals(null)) {
            throw new RuntimeException("Cuenta no encontrada");
		} else {
			cmet.save(c);
			return "la ciudad se actualizo";

		}
		
	}
}