package com.bhopal.demo;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bhopal.demo.dao.AlienDao;
import com.bhopal.demo.model.Alien;
@ControllerAdvice
@RestController
public class AlienController  
{      

	@Autowired
	 AlienDao repo;

	//we are add data into database
	@PostMapping(path="/addAlien")
     public Alien add( Alien alien) 
	{
	repo.save(alien);
	return alien;	
	
    }
	
	//We are deleteing a data from database bases of id....here Id is primary key in database.
	@DeleteMapping(path="deleteAlien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a=repo.getOne(aid);
		repo.delete(a);
		return "Data Deleted";
	}
    
	
	//updating the data 
	@PutMapping(path="/update")
	public Alien update(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	
	//fetching the data formate is json from data bases.
	@GetMapping("/getAlien")

	public  List<Alien> getAlien() {
		
	return repo.findAll();	
		
		
	}
	
	
	//fetching data bases of ID ..Data formate is Json.
	@GetMapping("/getAliens/{aid}")
	
	public Optional<Alien> getAliens(@PathVariable("aid") int aid) {
		
	return repo.findById(aid);	
		
		
	}
	
}

