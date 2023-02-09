package com.jbk.hms.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.hms.dao.PatientDao;
import com.jbk.hms.entity.Patient;
@Repository
public class PatientDaoIMPL implements PatientDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public boolean addPatient(Patient patient) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isAdded=false;
		try {
			session.save(patient);
			transaction.commit();
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
	public boolean deletePatientById(long id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted=false;
		try {
			 Patient patient = session.get(Patient.class, id);
			if (patient != null) {
				session.delete(patient);
				transaction.commit();
				isDeleted = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isDeleted;
	}

	@Override
	public Patient getPatientById(long id) {
		Session session = factory.openSession();
		Patient patient =null;
		try {
			 patient = session.get(Patient.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return patient;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Patient dbPatient = session.get(Patient.class, patient.getId());
			if (dbPatient != null) {
				session.evict(dbPatient);
				session.update(patient);
				transaction.commit();
				isUpdated = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
		
	}

	@Override
	public List<Patient> getAllPatients() {
		Session session = factory.openSession();
		List<Patient> list = null;
		try {

			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Patient.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {

				session.close();
			}
		}

		return list;
	}

	@Override
	public int getPatientsCount() {
		Session session = factory.openSession();
		long count = 0;

		try {

			Criteria criteria = session.createCriteria(Patient.class);
			criteria.setProjection(Projections.rowCount());
			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return (int) count;
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate() {
		Session session = factory.openSession();
		List<Patient> list =null;
		
		try {
			Criteria criteria=	session.createCriteria(Patient.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(5);
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
	public List<String> getAllPatientsIds() {
		// TODO Auto-generated method stub
		return null;
	}

}
