package MocupCSDL;

import java.util.List;
import java.util.Optional;

import com.example.model.Nhanvien;

public class NhanVienServiceMuckup {
	MockupNhanVienRepo mockupNhanVienRepo;
	
	
	public List<Nhanvien> deleteNV(String id){
		return mockupNhanVienRepo.deleteNV(id);
		  
	}
	
	public List<Nhanvien> getAll(){
		  return (List<Nhanvien>) mockupNhanVienRepo.getAll();		  
	}
	
	public List<Nhanvien> saveNV(Nhanvien nhanVien){
		  return mockupNhanVienRepo.saveNV(nhanVien);
	}
	
	public Nhanvien findNVById(String id){
		return  mockupNhanVienRepo.findNVById(id);
	}

	public void setMockupNhanVienRepo(MockupNhanVienRepo mockupNhanVienRepo) {
		this.mockupNhanVienRepo = mockupNhanVienRepo;
	}
	
}
