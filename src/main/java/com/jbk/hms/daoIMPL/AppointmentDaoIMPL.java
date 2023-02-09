package com.jbk.hms.daoIMPL;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.hms.dao.AppointmentDao;
import com.jbk.hms.entity.Appointment;

@Repository
public class AppointmentDaoIMPL implements AppointmentDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public boolean addAppointment(Appointment appointment) {
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isAdded = false;
		try {
			
			session.save(appointment);
			transaction.commit();
			isAdded=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return isAdded;
	}

	@Override
	public boolean updateAppointment(Appointment appointment) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		try {
			Appointment dbAppointment = session.get(Appointment.class, appointment.getAppointmentId());
			System.out.println(dbAppointment);
			if(dbAppointment!=null) {
				//session.evict(dbAppointment);
				session.update(appointment);
				transaction.commit();
				isUpdated = true;
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

	
	@Override
	public Appointment getAppointmentByAppointmentId(long appointmentId) {
		Session session = factory.openSession();
		Appointment appointment = null;
		try {
			
		appointment = session.get(Appointment.class, appointmentId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return appointment;
	}

	

	@Override
	public List<Appointment> getAppointmentsByDate(Date date) {
		Session session = factory.openSession();
		List<Appointment> list =null;
		try {
			Criteria criteria = session.createCriteria(Appointment.class);
			criteria.add(Restrictions.eq("date", date));
			
			 list = criteria.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public Long getAppointmentsTotalCount() {
		Session session = factory.openSession();
		long count = 0;
		
		try {
			Criteria criteria = session.createCriteria(Appointment.class);
			criteria.setProjection(Projections.rowCount());
			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				count = list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> getAllAppointments() {
		Session session = factory.openSession();
		List<Appointment> list =null;
		try {
		  Criteria criteria = session.createCriteria(Appointment.class);
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
	public List<Appointment> getTop5AppointmentsById() {
		Session session = factory.openSession();
		List<Appointment> list =null;
		
		try {
			Criteria criteria=	session.createCriteria(Appointment.class);
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

}
