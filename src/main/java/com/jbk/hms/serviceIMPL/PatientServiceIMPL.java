package com.jbk.hms.serviceIMPL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.hms.dao.PatientDao;
import com.jbk.hms.entity.Patient;
import com.jbk.hms.service.PatientService;
@Service
public class PatientServiceIMPL implements PatientService {

	@Autowired
	private PatientDao patientDao;
	
	@Override
	public boolean addPatient(Patient patient) {
		
		return patientDao.addPatient(patient);
	}

	@Override
	public boolean deletePatientById(long id) {
		
		return patientDao.deletePatientById(id);
	}

	@Override
	public Patient getPatientById(long id) {
		
		return patientDao.getPatientById(id);
	}

	@Override
	public boolean updatePatient(Patient patient) {
		
		return patientDao.updatePatient(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return patientDao.getAllPatients();
	}

	@Override
	public int getPatientsCount() {
		
		return patientDao.getPatientsCount();
	}

	@Override
	public List<Patient> getTop5PatientAddedByDate() {
		
		return patientDao.getTop5PatientAddedByDate();
	}

	@Override
	public List<String> getAllPatientsIds() {
		
		return patientDao.getAllPatientsIds();
	}

}
