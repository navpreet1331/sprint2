package com.capgemini.onlinemoviebooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.capgemini.onlinemoviebooking.dao.TheaterDao;
import com.capgemini.onlinemoviebooking.entity.Theater;
import com.capgemini.onlinemoviebooking.exception.TheaterException;

@Service
@Transactional
public class TheaterServiceImp implements TheaterService{

	@Autowired
	TheaterDao theaterDao;
	
	@Override
	public Theater addTheater(Theater theater) {
		return theaterDao.save(theater);
		
	}

	@Override
	public Boolean deleteTheater(Integer theaterId) {
		if(theaterDao.findById(theaterId).isPresent()) {
			theaterDao.deleteById(theaterId);
			return true;
		}
			
		else
			throw new TheaterException("Theater ID "+theaterId+" does not exists");
			
		
		
	}

	@Override
	public List<Theater> showAllTheater() {
		return theaterDao.findAll();
		
	}
	@Override
	public Theater showTheater(int id) {
		Optional<Theater> theater=theaterDao.findById(id);
		if(theater.isPresent())
			return theater.get();
		
		else 
			return null;
	}

	
}
