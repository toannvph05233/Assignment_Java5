package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Hoadonchitiet;
import com.example.repository.IHoaDonChiTietRepo;

@Service
public class HoaDonChiTietService {
	@Autowired IHoaDonChiTietRepo iHoaDonChiTietRepo;
	
	public List<Hoadonchitiet> getAll(){
		return (List<Hoadonchitiet>) iHoaDonChiTietRepo.findAll();
	}
	
	public Optional<Hoadonchitiet> findSPById(Long id){
		return  iHoaDonChiTietRepo.findById(id);
	}
	
	public void deleteHoaDonChiTiet(Long id){
		iHoaDonChiTietRepo.deleteById(id);		
	}
	
	public Hoadonchitiet saveHoaDonChiTiet(Hoadonchitiet hoaDon){
		return  iHoaDonChiTietRepo.save(hoaDon);
	}
	
}

