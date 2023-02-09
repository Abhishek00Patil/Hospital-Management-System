package com.jbk.hms.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.hms.dao.HospitalDao;
import com.jbk.hms.entity.Hospital;
@Repository
public class HospitalDaoIMPL implements HospitalDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean saveHospital(Hospital hospital) {
		
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		boolean isAdded = false;
		
		try {
			
			session.save(hospital);
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

	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public Hospital getHospitalByName(String hospitalName) {
		Session session = factory.openSession();
		
		Hospital hospital=null;
		try {
			
			Criteria criteria = session.createCriteria(Hospital.class);
			criteria.add(Restrictions.eq("hospitalName", hospitalName));
			List<Hospital> list = criteria.list();
			if(!list.isEmpty()) {
				 hospital = list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return hospital;
	}

	@Override
	public Hospital getHospitalById(long hospitalCode) {
		Session session = factory.openSession();
		Hospital hospital = null;
		
		try {
			
			 hospital = session.get(Hospital.class, hospitalCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return hospital;
	}

	@Override
	public List<Hospital> getAllHospital() {
		Session session = factory.openSession();
		List<Hospital> list = null;
		try {
			Criteria criteria=	session.createCriteria(Hospital.class);
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
	public boolean deleteHospitalByCode(long hospitalCode) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		boolean isDeleted =false;
		try {
			Hospital hospital = session.get(Hospital.class, hospitalCode);
			if(hospital!=null) {
				
				session.delete(hospital);
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
	public boolean updateHospital(Hospital hospital) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		boolean isUpdated =false;
		try {
			Hospital dbHospital = session.get(Hospital.class, hospital.getHospitalId());
			if(dbHospital!=null) {
				
				session.evict(dbHospital);
				session.update(hospital);
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
