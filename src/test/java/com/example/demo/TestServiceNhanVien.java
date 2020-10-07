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

import MocupCSDL.MockupNhanVienRepo;
import MocupCSDL.NhanVienServiceMuckup;

@SpringBootTest
@TestConfiguration
public class TestServiceNhanVien {
	NhanVienServiceMuckup nhanVienServiceMuckup;
	 List<Nhanvien> listNV;
	 Nhanvien nv;
	 
	
	 @MockBean
	 MockupNhanVienRepo mockupNhanVienRepo;
	 
	 @BeforeEach
	  public void init() {
		 nhanVienServiceMuckup = new NhanVienServiceMuckup();
		 nhanVienServiceMuckup.setMockupNhanVienRepo(mockupNhanVienRepo);
		  listNV = new ArrayList<Nhanvien>();
		  nv = new Nhanvien();
		 
		
		
		 long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			
			nv.setManv("abc");
			nv.setMatkhau("abc");
			nv.setNgayvao(date);
			nv.setQuequan("abc");
			nv.setSodt("abc");
			nv.setTennv("abc");
			
			listNV.add(nv);
			
			
	 }
	 
	 @AfterEach
	 public void end() {
		 nhanVienServiceMuckup = null;		
		  listNV =null;
		  nv =null;
		 
		
	 }
	 
	@Test
    public void testGetAll() {		 
		 when(mockupNhanVienRepo.getAll()).thenReturn(listNV);
		 Assertions.assertEquals(listNV,nhanVienServiceMuckup.getAll());
    }	
	
	 @Test
	    public void testSave() {					
			 when(mockupNhanVienRepo.saveNV(nv)).thenReturn(listNV);
			 Assertions.assertEquals(listNV,nhanVienServiceMuckup.saveNV(nv));
	    }
	 @Test
	    public void testSaveNull() {	
		 try {
			 when(mockupNhanVienRepo.saveNV(new Nhanvien())).thenReturn(listNV);

		} catch (Exception e) {
			Assertions.assertEquals("", e.getMessage());
		}
			 
	    }
	 @Test
	    public void testFindById() {					
			 when(mockupNhanVienRepo.findNVById("abc")).thenReturn(nv);
			 Assertions.assertEquals(nv,nhanVienServiceMuckup.findNVById("abc"));
	    }
	 
	 @Test
	    public void testFindByIdNull() {					
			 when(mockupNhanVienRepo.findNVById("")).thenReturn(null);
			 Assertions.assertEquals(null,nhanVienServiceMuckup.findNVById(""));
	    }
	 @Test
	    public void testDeleteById() {
		 
			Nhanvien nv2 = new Nhanvien();
			nv2.setManv("abcd");
			nv2.setMatkhau("abcd");
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			nv2.setNgayvao(date);
			nv2.setQuequan("abcd");
			nv2.setSodt("abcd");
			nv2.setTennv("abcd");
			listNV.add(nv2);
	
			
		 
			 when(mockupNhanVienRepo.deleteNV("abc")).thenReturn(listNV);
			 System.out.println(listNV.size());
			 System.out.println(nhanVienServiceMuckup.deleteNV("abc").size());
			 Assertions.assertEquals(listNV,nhanVienServiceMuckup.deleteNV("abc"));
	    }
	 
	 @Test
	    public void testDeleteByIdNull() {
		 		 
			 when(mockupNhanVienRepo.deleteNV("")).thenReturn(listNV);
			 Assertions.assertEquals(listNV,nhanVienServiceMuckup.deleteNV(""));
	    }

}
