package com.example.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the giamgia database table.
 * 
 */
@Entity
@NamedQuery(name="Giamgia.findAll", query="SELECT g FROM Giamgia g")
public class Giamgia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String magiamgia;

	private double chitietgiam;

	private byte trangthai;

	
	public Giamgia() {
	}

	public String getMagiamgia() {
		return this.magiamgia;
	}

	public void setMagiamgia(String magiamgia) {
		this.magiamgia = magiamgia;
	}

	public double getChitietgiam() {
		return this.chitietgiam;
	}

	public void setChitietgiam(double chitietgiam) {
		this.chitietgiam = chitietgiam;
	}

	public byte getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(byte trangthai) {
		this.trangthai = trangthai;
	}


}