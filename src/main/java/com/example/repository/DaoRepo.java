package com.example.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.model.Sanpham;

@Repository
@Transactional
public class DaoRepo {
	
		@PersistenceContext  
		private EntityManager entityManager;
		
		public Session getSession(){
			Session session =entityManager.unwrap(Session.class);
			return session;
		}

		public Long getCoutSP() {
			Session session = getSession();
			String hql1 = "select sum(soluong) from Sanphamsize";
			Query query1 = session.createQuery(hql1);
			return (Long) query1.uniqueResult();
	
		}
	
		public Long getCoutHD() {
			Session session = getSession();
			String hql2 = "select count(mahoadon) from Hoadon";
			Query query2 = session.createQuery(hql2);
			return (Long) query2.uniqueResult();
	
		}
		public Long getCoutLSP(String loaiSP) {
			Session session = getSession();
			
			String hql2 = "SELECT sum(e.soluong) FROM Sanphamsize e join e.sanpham s where s.loaisanpham ='"+loaiSP+"'";
			Query query2 = session.createQuery(hql2);
			return (Long) query2.uniqueResult();
	
		}
	
		public Double getSumPrice() {
			Session session = getSession();
			String hql3 = "select sum(tongtien) from Hoadon";
			Query query3 = session.createQuery(hql3);
			return (Double) query3.uniqueResult();
	
		}
	
		public ArrayList<Sanpham> getListLSP(String loaiSP) {
			Session session = getSession();
			
			String hql4 = "from Sanpham where masanpham like '%" + loaiSP + "%'";
			Query<Sanpham> query4 = session.createQuery(hql4, Sanpham.class);
	
			return (ArrayList) query4.list();
	
		}
	
		public Long getCoutNV() {
			Session session = getSession();
			String hql5 = "select count(manv) from Nhanvien";
			Query query5 = session.createQuery(hql5);
			return (Long) query5.uniqueResult();
	
		}
	}

