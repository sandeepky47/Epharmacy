package com.spring.epharma.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.epharma.dao.MedicineDao;
import com.spring.epharma.model.Medicine;
/**
 * serviceImp class which implements MedicieService iterface
 */
@Service
public class MedicineServiceImp implements MedicineService {
	/**
	 * autowiring MedicieDao class
	 */
	@Autowired
	private MedicineDao medidao;

	@Override
	public List<Medicine> getExpiredMedicine(final Date currentDate) {
		
		return medidao.getExpiredMedicine(currentDate);
		
	}

	@Override
	public void addMedicine(final Medicine medicine) {
		medidao.addMedicine(medicine);
	}

	@Override
	public List<Medicine> getAllMedicine() {
		return medidao.getAllMedicine();
	}

	@Override
	public void deleteMedicine(final int medicineId) {
		medidao.deleteMedicine(medicineId);
		
	}

	@Override
	public void editMedicine(final Medicine medicine) {
		medidao.editMedicine(medicine);
		
	}

	@Override
	public Medicine getMedicineById(final int medicineId) {
      return medidao.getMedicineById(medicineId);
	}

	
	
	

}
