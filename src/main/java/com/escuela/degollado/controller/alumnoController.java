package com.escuela.degollado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escuela.degollado.model.Alumno;
import com.escuela.degollado.pojo.Response;
import com.escuela.degollado.service.AlumnoService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api(tags = "APIS de alumnos")
public class alumnoController {

	@Autowired
	AlumnoService service;

	@GetMapping("/alumnos")
	public ResponseEntity<Response> getAllAlumnos(){
		try {
			Object response = service.getAllAlumnos();
			return new ResponseEntity<Response>(new Response(true,"Success", response),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Response>(new Response(false,"error: "+ e.getMessage(),null),HttpStatus.OK);
		}
	}

	@GetMapping("/alumno/id")
	public ResponseEntity<Response> getById(@RequestParam int id){
		try {
			Object response = service.getByIdAlumno(id);
			return new ResponseEntity<Response>(new Response(true,"Success", response),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Response>(new Response(false,"error: "+ e.getMessage(),null),HttpStatus.OK);
		}
	}

	@DeleteMapping("/alumno/id")
	public ResponseEntity<Response> deleteAlumno(@RequestParam("id") int id) {
		try {
			Object response = service.getByIdAlumno(id);
			service.deleteById(id);
			return new ResponseEntity<Response>(new Response(true, "Success Eliminado", response), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<Response>(new Response(false, "Error " + e.getMessage(), null), HttpStatus.OK);
		}
	}

	// api post agregar
	@PostMapping("/alumnos")
	public ResponseEntity<Response> addAlumnos(@RequestBody Alumno alumno) {
		try {
			this.service.saveAlumno(alumno);
			Response response = new Response(true, "Success!", alumno);
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		} catch (Exception e) {
			Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}
	// api para modificar
	@PutMapping("/alumnos")
	public ResponseEntity<Response> updateAlumnos(@RequestBody Alumno alumno) {
		try {
			this.service.updateAlumno(alumno);
			Response response = new Response(true, "Success!", alumno);
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		} catch (Exception e) {
			Response response = new Response(false, "Error!, ..." + e.getMessage(), null);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
	}

}
