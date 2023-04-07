package com.cibertec.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.cliente.entity.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer>{
	@Query("select e from Edificio e where e.tipo.codigo=?1")
	public List<Edificio> listarEdificiosPorTipo(int cod);
}
