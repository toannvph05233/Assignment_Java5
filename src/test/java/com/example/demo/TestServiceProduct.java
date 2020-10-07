package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Nhanvien;
import com.example.model.SanPhamVO;

import MocupCSDL.MockupProductRepo;
import MocupCSDL.ProducSevriceMockup;

@SpringBootTest
@TestConfiguration
public class TestServiceProduct {
	ProducSevriceMockup producSevriceMockup;
	List<SanPhamVO> listSP;
	SanPhamVO sp;

	@MockBean
	MockupProductRepo mockupProductRepo;

	@BeforeEach
	public void init() {
		producSevriceMockup = new ProducSevriceMockup();
		producSevriceMockup.setiProductRepo(mockupProductRepo);

		listSP = new ArrayList<>();

		sp = new SanPhamVO();
		sp.setGiaban(50);
		sp.setGianhap(50);
		sp.setHinhanh("abc");
		sp.setMagiamgia("abc");
		sp.setMaloai("abc");
		sp.setMasanpham("abc");
		sp.setMau("abc");
		sp.setMotasanpham("abc");

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		sp.setNgaynhapkho(date);
		sp.setTensanpham("abc");
		sp.setTrangthai((byte) 1);

		listSP.add(sp);
	}

	@AfterEach
	public void end() {
		producSevriceMockup = null;
		listSP = null;
		sp = null;
	}

	@Test
	public void testGetProductRepo() {
		Assertions.assertEquals(mockupProductRepo, producSevriceMockup.getiProductRepo());
	}

	@Test
	public void testGetAll() {
		when(mockupProductRepo.getAll()).thenReturn(listSP);
		Assertions.assertEquals(listSP, producSevriceMockup.getAll());
	}

	@Test
	public void testSave() {
		when(mockupProductRepo.save(sp)).thenReturn(listSP);
		List<SanPhamVO> listSP1 = producSevriceMockup.saveSP(sp);
		Assertions.assertEquals(listSP, listSP1);
	}

	@Test
	public void testSaveNull() {
		try {
			when(mockupProductRepo.save(new SanPhamVO())).thenReturn(listSP);

		} catch (Exception e) {
			Assertions.assertEquals("", e.getMessage());
		}

	}

	@Test
	public void testFindById() {
		when(mockupProductRepo.findById("abc")).thenReturn(sp);
		Assertions.assertEquals(sp, producSevriceMockup.findSPById("abc"));
	}
	
	@Test
	public void testFindByIdNull() {
		when(mockupProductRepo.findById("")).thenReturn(null);
		Assertions.assertEquals(null, producSevriceMockup.findSPById(""));
	}

	@Test
	public void testDeleteById() {

		SanPhamVO sp2 = new SanPhamVO();
		sp.setGiaban(50);
		sp.setGianhap(50);
		sp.setHinhanh("abcd");
		sp.setMagiamgia("abcd");
		sp.setMaloai("abcd");
		sp.setMasanpham("abcd");
		sp.setMau("abcd");
		sp.setMotasanpham("abcd");

		long millis2 = System.currentTimeMillis();
		java.sql.Date date2 = new java.sql.Date(millis2);

		sp.setNgaynhapkho(date2);
		sp.setTensanpham("abcd");
		sp.setTrangthai((byte) 1);

		listSP.add(sp2);

		when(mockupProductRepo.deleteById("abc")).thenReturn(listSP);
		Assertions.assertEquals(listSP, producSevriceMockup.deleteSP("abc"));
	}
	
	@Test
	public void testDeleteByIdNull() {

		when(mockupProductRepo.deleteById("")).thenReturn(listSP);
		Assertions.assertEquals(listSP, producSevriceMockup.deleteSP(""));
	}
}
