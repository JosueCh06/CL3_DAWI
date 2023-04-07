package com.cibertec.cliente.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tipo")
public class Tipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_tipo")
	private Integer codigo;
	
	@Column(name="nom_tipo")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipo")
	private List<Edificio> listaEdificios;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Edificio> getListaEdificios() {
		return listaEdificios;
	}

	public void setListaEdificios(List<Edificio> listaEdificios) {
		this.listaEdificios = listaEdificios;
	}
	
	
	
	
	
	
}
