package com.bhopal.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bhopal.demo.model.Alien;



public interface AlienDao  extends JpaRepository<Alien, Integer>
{

}
