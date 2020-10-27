package co.edu.unicauca.asae.core.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String calle;
	private String ciudad;
	private String pais;
	
	//@Transient
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario objUsuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Usuario getObjUsuario() {
		return objUsuario;
	}
	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}
	
	
	
}
