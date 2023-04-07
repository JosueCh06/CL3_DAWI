package com.cibertec.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cliente.entity.Edificio;
import com.cibertec.cliente.repository.EdificioRepository;

@Service
public class EdificioServicie {
	@Autowired
	private EdificioRepository repo;
	
	public void registrar(Edificio bean) {
		repo.save(bean);
	}
	
	public List<Edificio> listarAllPorTipo(int cod){
		return repo.listarEdificiosPorTipo(cod);
	}
	
	
}
