package com.jbk.hms.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.hms.dao.DoctorDao;
import com.jbk.hms.entity.Doctor;
import com.jbk.hms.entity.Hospital;

@Repository
public class DoctorDaoIMPL implements DoctorDao {

	@Autowired
	private SessionFactory factory;
	
	
	@Override
	public boolean saveDoctor(Doctor doctor) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		boolean isAdded = false;
		
		try {
			
			session.save(doctor);
			tran.commit();
			isAdded=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public Doctor getDoctorById(long doctorId) {
		Session session = factory.openSession();
		Doctor doctor =null;
		try {
			
			 doctor = session.get(Doctor.class, doctorId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return doctor;
	}

	@Override
	public Doctor getDoctorByName(String doctorName) {
      Session session = factory.openSession();
		
		Doctor doctor=null;
		try {
			
			Criteria criteria = session.createCriteria(Doctor.class);
			criteria.add(Restrictions.eq("doctorName", doctorName));
			List<Doctor> list = criteria.list();
			if(!list.isEmpty()) {
				   doctor = list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return doctor;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		Session session = factory.openSession();
		List<Doctor> list = null;
		try {
			Criteria criteria=	session.createCriteria(Doctor.class);
			 list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	@Override
	public boolean deleteDoctorById(long doctorId) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		boolean isDeleted =false;
		try {
			Doctor doctor =session.get(Doctor.class, doctorId);
			if(doctor!=null) {
				
				session.delete(doctor);
				tran.commit();
				isDeleted=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return isDeleted;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		boolean isUpdated =false;
		try {
			Doctor dbDoctor = session.get(Doctor.class, doctor.getDoctorId());
			if(dbDoctor!=null) {
				
				session.evict(dbDoctor);
				session.update(doctor);
				tran.commit();
				isUpdated=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return isUpdated;
	}

}
