package MocupCSDL;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Giamgia;
import com.example.model.Hoadonchitiet;
import com.example.model.Loaisanpham;
import com.example.model.SanPhamVO;
import com.example.model.Sanpham;
import com.example.model.Sanphamsize;

@Repository
public class MockupProductRepo {
	
	public List<SanPhamVO> getAll() {
		List<SanPhamVO> listSP = new ArrayList<>();

		SanPhamVO sp = new SanPhamVO();
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

		return listSP;
	}
	
	public  List<SanPhamVO> save(SanPhamVO sanPhamVO){
		SanPhamVO sp = new SanPhamVO();
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

		
		List<SanPhamVO> listSP = new ArrayList<>();
		listSP.add(sp);
		listSP.add(sanPhamVO);
		return  listSP;
	}
	
	
	public  SanPhamVO findById(String id){
		List<SanPhamVO> listSP = new ArrayList<>();
		
		SanPhamVO sp = new SanPhamVO();
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
		
		for (int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getMasanpham().equals(id)) {
				return listSP.get(i);
			}
		}

		return  null;
	}
	
	public  List<SanPhamVO> deleteById(String id){
		
		List<SanPhamVO> listSP = new ArrayList<>();
		
		SanPhamVO sp = new SanPhamVO();
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
		
		
		listSP.add(sp);
		listSP.add(sp2);
		
		for (int i = 0; i < listSP.size(); i++) {
			if(listSP.get(i).getMasanpham().equals(id)) {
				listSP.remove(i);
			}
		}

		return  listSP;
	}
	
	
}
