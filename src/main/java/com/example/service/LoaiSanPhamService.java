package com.example.service;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Loaisanpham;
import com.example.model.Nhanvien;
import com.example.repository.ILoaiSanPhamRepo;

@Service
public class LoaiSanPhamService {

	@Autowired
	ILoaiSanPhamRepo iLoaiSanPhamRepo;
	
	
	public Optional<Loaisanpham> findById(String id){
		return  iLoaiSanPhamRepo.findById(id);
	}
}
