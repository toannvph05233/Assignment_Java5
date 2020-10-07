package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Sanphamsize;
import com.example.model.Size;
import com.example.repository.ISanPhamSize;

@Service
public class SanPhamSizeService {
	@Autowired
	ISanPhamSize iSanPhamSize;
	

	public List<Sanphamsize> getAll(){
		return (List<Sanphamsize>) iSanPhamSize.findAll();
	}
	
	public Optional<Sanphamsize> findSizeById(Long id){
		return  iSanPhamSize.findById(id);
	}
	
	public Sanphamsize save(Sanphamsize sanphamsize){
		return  iSanPhamSize.save(sanphamsize);
	}
}
