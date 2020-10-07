package MocupCSDL;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.model.SanPhamVO;
import com.example.model.Sanpham;

public class ProducSevriceMockup {
	MockupProductRepo iProductRepo;
	
	
	public ProducSevriceMockup() {
		super();
	}


	public MockupProductRepo getiProductRepo() {
		return iProductRepo;
	}


	public void setiProductRepo(MockupProductRepo iProductRepo) {
		this.iProductRepo = iProductRepo;
	}


	public List<SanPhamVO> getAll(){
		return (List<SanPhamVO>) iProductRepo.getAll();
	}

	public List<SanPhamVO> saveSP(SanPhamVO sanPhamVO){
		return  iProductRepo.save(sanPhamVO);
	}

	public SanPhamVO findSPById(String id){
		return  iProductRepo.findById(id);
	}

	public List<SanPhamVO> deleteSP(String id){
		return iProductRepo.deleteById(id);		
	}

}
