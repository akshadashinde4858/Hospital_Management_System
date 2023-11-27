package com.ty.springboot_hospital_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hospital_app.dao.HospitalDao;
import com.ty.springboot_hospital_app.dto.Hospital;
import com.ty.springboot_hospital_app.service.exception.DataNotFoundException;
import com.ty.springboot_hospital_app.service.exception.EmailNotFoundException;
import com.ty.springboot_hospital_app.service.exception.IdNotFoundException;
import com.ty.springboot_hospital_app.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		structure.setMessage("Successfully Saved");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		Hospital dbHospital = dao.updateHospital(id, hospital);
		if (dbHospital != null) {
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
		Hospital hospital = dao.deleteHospital(id);
		if (hospital != null) {
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		Hospital hospital = dao.getHospitalById(id);
		if (hospital != null) {
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Id not found for Hospital");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Hospital>>> findAllHospitals()
	{
		List<Hospital> list=dao.getAllHospitals();
		if(list.isEmpty())
		{
			throw new DataNotFoundException("Data Not found");
		}
		else
		{
			ResponseStructure<List<Hospital>> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(list);
			return new ResponseEntity<ResponseStructure<List<Hospital>>>(structure, HttpStatus.FOUND);
		}
	}
	
//	public ResponseEntity<ResponseStructure<Hospital>> findHospitalByEmail(String email)
//	{
//		Hospital hospital = dao.getHospitalByEmail(email);
//		if (hospital != null) {
//			ResponseStructure<Hospital> structure = new ResponseStructure<>();
//			structure.setMessage("Successfully Found");
//			structure.setStatus(HttpStatus.OK.value());
//			structure.setData(hospital);
//			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
//		} else {
//			throw new EmailNotFoundException("email not found for Hospital");
//		}
//	}
}
