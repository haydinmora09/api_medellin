package co.edu.usbbog.bdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cuenta {
	
	@Id
	private long num;
	@Column
	private String cedula;
	@Column
	private String nombre;
	@Column
	private String telefono;
	@Column
	private Double saldo;
	@JoinColumn(name = "ciudad", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
	private Ciudad ciudad;
	
	public Cuenta(long num, String cedula, String nombre, String telefono, Double saldo) {
		super();
		this.num = num;
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.saldo = saldo;
	}
	
	public Cuenta() {
		super();
		this.num = 0;
		this.cedula = "";
		this.nombre = "";
		this.telefono = "";
		this.saldo = 0.0;
		this.ciudad = null;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + (int) (num ^ (num >>> 32));
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (num != other.num)
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [num=" + num + ", cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", saldo=" + saldo + ", ciudad=" + ciudad.toString() + "]";
	}
	
}