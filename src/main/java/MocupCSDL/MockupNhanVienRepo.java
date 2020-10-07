package MocupCSDL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.model.Nhanvien;

public class MockupNhanVienRepo {
	Nhanvien nv = new Nhanvien();
	Nhanvien nv2 = new Nhanvien();
	List<Nhanvien> listNV = new ArrayList<Nhanvien>();
	
	public void createNV() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		
		nv.setManv("abc");
		nv.setMatkhau("abc");
		nv.setNgayvao(date);
		nv.setQuequan("abc");
		nv.setSodt("abc");
		nv.setTennv("abc");
		listNV.add(nv);
		
		nv2.setManv("abcd");
		nv2.setMatkhau("abcd");
		nv2.setNgayvao(date);
		nv2.setQuequan("abcd");
		nv2.setSodt("abcd");
		nv2.setTennv("abcd");
		listNV.add(nv2);
		
	}
	
	public List<Nhanvien> deleteNV(String id){
		createNV();
		for (int i = 0; i < listNV.size(); i++) {
			if(listNV.get(i).getManv().equals(id)) {
				listNV.remove(i);
			}
		}
		return listNV;
	}
	
	
	public List<Nhanvien> getAll(){
		createNV();
		  return listNV;		  
	}
	
	public List<Nhanvien> saveNV(Nhanvien nhanVien){
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		
		nv.setManv("abc");
		nv.setMatkhau("abc");
		nv.setNgayvao(date);
		nv.setQuequan("abc");
		nv.setSodt("abc");
		nv.setTennv("abc");
		listNV.add(nv);
		listNV.add(nhanVien);
		return listNV;
	}
	

	public Nhanvien findNVById(String id){
		createNV();
		for (int i = 0; i < listNV.size(); i++) {
			if(listNV.get(i).getManv().equals(id)) {
				return  listNV.get(i);
			}
		}
		
		return  null;
	}
}
