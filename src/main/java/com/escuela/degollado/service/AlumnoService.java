package com.escuela.degollado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuela.degollado.model.Alumno;
import com.escuela.degollado.repository.AlumnoRepo;

@Service
public class AlumnoService {

	@Autowired
	AlumnoRepo repo;
	
	public List<Alumno> getAllAlumnos(){
		return this.repo.findAll();
	}
	public List<Alumno> getByIdAlumno(int id){
		return this.repo.findById(id);
	}
	public void deleteById(int id) {
		this.repo.deleteById(id);
	}
	public void saveAlumno(Alumno alumno) {
		this.repo.save(alumno);
	}
	public void updateAlumno(Alumno alumno) {
		this.repo.save(alumno);
	}
}
