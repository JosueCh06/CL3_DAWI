package com.cibertec.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.cliente.entity.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
