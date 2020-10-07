package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Hoadonchitiet;
import com.example.model.Size;
import com.example.repository.ISizeRepo;

@Service
public class SizeService {
	@Autowired
	ISizeRepo iSizeRepo;
	
	public List<Size> getAll(){
		return (List<Size>) iSizeRepo.findAll();
	}
	
	public Optional<Size> findSizeById(String id){
		return  iSizeRepo.findById(id);
	}
	
	public Size save(Size size){
		return  iSizeRepo.save(size);
	}
	
}
