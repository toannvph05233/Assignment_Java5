package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.model.Loaisanpham;
import com.example.model.Sanpham;
import com.example.model.Size;

public interface ISizeRepo extends CrudRepository<Size, String>{

	Optional<Size> findById(String id);
 

}
