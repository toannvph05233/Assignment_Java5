package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Sanpham;
import com.example.service.ProductService;



@CrossOrigin("*")
@RestController
public class SearchController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("admin/searchSP/{name}")
	public List<Sanpham> searchSP(@PathVariable String name){
		return productService.findSPByName(name);
	}

}
