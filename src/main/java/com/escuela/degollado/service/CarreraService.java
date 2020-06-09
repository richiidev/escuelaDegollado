package com.escuela.degollado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuela.degollado.model.Carrera;
import com.escuela.degollado.repository.CarreraRepo;

@Service
public class CarreraService {

	@Autowired
	CarreraRepo repo;
	
	public List<Carrera> getAllCarreras(){
		return this.repo.findAll();
	}
	public List<Carrera> getByIdCarrera(int id){
		return this.repo.findById(id);
	}
	public void deleteById(int id) {
		this.repo.deleteById(id);
	}
	public void saveCarrera(Carrera carrera) {
		this.repo.save(carrera);
	}
	public void updateCarrera(Carrera carrera) {
		this.repo.save(carrera);
	}
}
