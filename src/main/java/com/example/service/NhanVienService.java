package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.CustomUserDetails;
import com.example.model.Nhanvien;
import com.example.repository.INhanVienRepo;

@Service
public class NhanVienService implements UserDetailsService {

	@Autowired
	INhanVienRepo iNhanVienRepo;

	public void deleteNV(String id) {
		iNhanVienRepo.deleteById(id);
		System.out.println("delete thanh cong");
	}

	public List<Nhanvien> getAll() {
		return (List<Nhanvien>) iNhanVienRepo.findAll();
	}

	public void saveNV(Nhanvien nhanVien) {
		iNhanVienRepo.save(nhanVien);
		System.out.println("save thanh cong");
	}

	public Optional<Nhanvien> findNVById(String id) {
		return iNhanVienRepo.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Nhanvien user = iNhanVienRepo.findById(username).get();
		System.out.println("-------------------------------------");
		System.out.println(user.getMatkhau());
		System.out.println("-------------------------------------");
		
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

}
