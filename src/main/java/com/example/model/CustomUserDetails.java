package com.example.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails{
	Nhanvien nhanvien;

	
	public CustomUserDetails(Nhanvien nhanvien) {
		super();
		this.nhanvien = nhanvien;
	}

	public CustomUserDetails() {
		super();
	}

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("1"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return nhanvien.getMatkhau();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nhanvien.getManv();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
