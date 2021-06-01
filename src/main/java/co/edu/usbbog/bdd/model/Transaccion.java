package co.edu.usbbog.bdd.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

 @Entity
public class Transaccion {
	@Id
	private long id;
	@Column
	private double valor;
	@Column(nullable = false,name = "fecha",columnDefinition = "DATETIME")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha;
	@JoinColumn(name = "tipo", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
	private TipoTransaccion tipo;
	@JoinColumn(name = "cuenta", referencedColumnName = "num", nullable = false)
    @ManyToOne(optional = false)
	private Cuenta cuenta;
	
	
	public Transaccion(long id, double valor, LocalDateTime fecha) {
		super();
		this.id = id;
		this.valor = valor;
		this.fecha = fecha;
	}
	
	
	public Transaccion() {
		super();
		this.id = 0;
		this.valor = 0.0;
		this.fecha = null;
		this.tipo = null;
		this.cuenta = null;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public TipoTransaccion getTipo() {
		return tipo;
	}
	public void setTipo(TipoTransaccion tipo) {
		this.tipo = tipo;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Transaccion other = (Transaccion) obj;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", valor=" + valor + ", fecha=" + fecha + ", tipo=" + tipo.toString() + ", cuenta="
				+ cuenta.toString() + "]";
	}
	
}