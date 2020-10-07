package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Hoadon;
import com.example.model.Hoadonchitiet;
import com.example.model.Nhanvien;
import com.example.model.SanPhamVO;
import com.example.model.Sanpham;
import com.example.model.Sanphamsize;
import com.example.model.Size;
import com.example.repository.DaoRepo;
import com.example.service.GiamGiaService;
import com.example.service.HoaDonChiTietService;
import com.example.service.HoaDonService;
import com.example.service.LoaiSanPhamService;
import com.example.service.NhanVienService;
import com.example.service.ProductService;
import com.example.service.SanPhamSizeService;
import com.example.service.SizeService;

@Controller
@Transactional
@RequestMapping("/sanpham/")
public class QuanLyController {
	@Autowired
	EntityManagerFactory factory;
	@Autowired
	ProductService productService;
	@Autowired
	NhanVienService nhanVienService;
	@Autowired
	HoaDonService hoaDonService;
	@Autowired
	HoaDonChiTietService hoaDonChiTietService;
	@Autowired
	GiamGiaService giamGiaService;
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	@Autowired
	SizeService sizeService;
	@Autowired
	DaoRepo daoRepo;
	@Autowired
	SanPhamSizeService sanPhamSizeService;
	
	
	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String homeAdmin(ModelMap model, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "JohnToan") String loaiSP) {
		
		Long sumSP = daoRepo.getCoutSP();
		Long sumHD = daoRepo.getCoutHD();
		Double sumPrice = daoRepo.getSumPrice();
		Long sumNV = daoRepo.getCoutNV();
		ArrayList<Sanpham> listSP =daoRepo.getListLSP(loaiSP);
		List<Sanpham> list;
		if (listSP.size() == 0) {
			list = productService.getAllByPage(size, page);
		} else {
			list = listSP;
		}
		
		List<Nhanvien> listNhanVien = nhanVienService.getAll();
		List<Hoadon> listHD = hoaDonService.getAll();
		List<Hoadonchitiet> listHoaDonChiTiet = hoaDonChiTietService.getAll();

		model.addAttribute("tong1", sumSP);
		model.addAttribute("tong2", sumNV);
		model.addAttribute("tong3", sumHD);
		model.addAttribute("tong5", sumPrice);
		model.addAttribute("list", list);
		model.addAttribute("listNhanVien", listNhanVien);
		model.addAttribute("listHoaDon", listHD);
		model.addAttribute("listHoaDonChiTiet", listHoaDonChiTiet);
		model.addAttribute("coutAo01", daoRepo.getCoutLSP("Ao01"));
		

		return "sanpham/indexAdmin";
	}

	@RequestMapping(value = "admin/create", method = RequestMethod.POST)
	public String CreateSP(@ModelAttribute SanPhamVO sanphamvo,@RequestParam("soluong") int soluong, @RequestParam("masize") String masize) {	
		Sanpham sanpham = new Sanpham();
				
		sanpham.setMasanpham(sanphamvo.getMasanpham());
		sanpham.setTensanpham(sanphamvo.getTensanpham());
		sanpham.setHinhanh(sanphamvo.getHinhanh());
		sanpham.setMau(sanphamvo.getMau());
		sanpham.setMotasanpham(sanphamvo.getMotasanpham());
		sanpham.setGiaban(sanphamvo.getGiaban());
		sanpham.setGianhap(sanphamvo.getGianhap());
		sanpham.setNgaynhapkho(sanphamvo.getNgaynhapkho());
		sanpham.setTrangthai(sanphamvo.getTrangthai());
		sanpham.setGiamgia(giamGiaService.findById(sanphamvo.getMagiamgia()).get());
		sanpham.setLoaisanpham(loaiSanPhamService.findById(sanphamvo.getMaloai()).get());
		
		Sanphamsize sanphamsize = new Sanphamsize();
		sanphamsize.setSanpham(sanpham);
		sanphamsize.setSize(sizeService.findSizeById(masize).get());
		sanphamsize.setSoluong(soluong);
		sanphamsize.setTrangthai((byte) 1);

		sanPhamSizeService.save(sanphamsize);
		
		productService.saveSP(sanpham);
		return "redirect:/sanpham/admin";
		
	}
	
	@RequestMapping(value = "admin/create", method = RequestMethod.GET)
	public String getCreateSP(ModelMap model) {	
		List<Size> listSize = sizeService.getAll();
		model.addAttribute("listSize", listSize);
		return "sanpham/createAdmin";
	}
	
	@RequestMapping(value = "admin/edit", method = RequestMethod.GET)
	public String getEditSP(ModelMap model, @RequestParam String id) {
		Sanpham sp = null;
		if(productService.findSPById(id)==null) {
			System.out.println("nillllllllllllllllllllllllllllllllllllll");
		}else {
			sp = productService.findSPById(id).get();
		}
		
		model.addAttribute("product", sp);
		return "sanpham/editAdmin";
	}
	
	@RequestMapping(value = "admin/edit", method = RequestMethod.POST)
	public String EditSP(@ModelAttribute SanPhamVO sanphamvo) {		
Sanpham sanpham = new Sanpham();
		
		System.out.println(sanphamvo.getMasanpham());
		
		sanpham.setMasanpham(sanphamvo.getMasanpham());
		sanpham.setTensanpham(sanphamvo.getTensanpham());
		sanpham.setHinhanh(sanphamvo.getHinhanh());
		sanpham.setMau(sanphamvo.getMau());
		sanpham.setMotasanpham(sanphamvo.getMotasanpham());
		sanpham.setGiaban(sanphamvo.getGiaban());
		sanpham.setGianhap(sanphamvo.getGianhap());
		sanpham.setNgaynhapkho(sanphamvo.getNgaynhapkho());
		sanpham.setTrangthai(sanphamvo.getTrangthai());
		sanpham.setGiamgia(giamGiaService.findById(sanphamvo.getMagiamgia()).get());
		sanpham.setLoaisanpham(loaiSanPhamService.findById(sanphamvo.getMaloai()).get());
		
		productService.saveSP(sanpham);
		System.out.println("ok");
		return "redirect:/sanpham/admin";
		
	}
	
	
	// Nhân Viên
	
	@RequestMapping(value = "admin/createNV", method = RequestMethod.GET)
	public String getCreateNV() {		
		return "sanpham/createNhanVien";
	}
	
	@RequestMapping(value = "admin/createNV", method = RequestMethod.POST)
	public String CreateNV(@ModelAttribute Nhanvien nhanVien) {		
		nhanVienService.saveNV(nhanVien);
		System.out.println("ok");
		return "redirect:/sanpham/admin";
		
	}
	
	@RequestMapping(value = "admin/editNV", method = RequestMethod.GET)
	public String getEditNV(ModelMap model, @RequestParam String id) {
		Nhanvien nv = null;
		if(nhanVienService.findNVById(id)==null) {
			System.out.println("nillllllllllllllllllllllllllllllllllllll");
		}else {
			nv = nhanVienService.findNVById(id).get();
		}
		
		model.addAttribute("nhanvien", nv);
		return "sanpham/editNhanVien";
	}
	
	@RequestMapping(value = "admin/editNV", method = RequestMethod.POST)
	public String EditNV(@ModelAttribute Nhanvien nhanVien) {		
		nhanVienService.saveNV(nhanVien);
		System.out.println("ok");
		return "redirect:/sanpham/admin";
		
	}
	
}
