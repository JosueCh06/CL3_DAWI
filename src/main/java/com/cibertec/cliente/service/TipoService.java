package com.cibertec.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cliente.entity.Tipo;
import com.cibertec.cliente.repository.TipoRepository;

@Service
public class TipoService {
	@Autowired
	private TipoRepository repo;
	
	public List<Tipo> listAll(){
		return repo.findAll();
	}
	
	
	
}
