package com.spring.epharma.service;

import java.util.Date;
import java.util.List;

import com.spring.epharma.model.Medicine;

 interface MedicineService {
	
 List<Medicine> getExpiredMedicine(Date curretDate);
 
  void addMedicine(Medicine medicine);
  
  List<Medicine> getAllMedicine();
  
   void deleteMedicine(int medicineId);
   
   void editMedicine(Medicine medicine);
   
   Medicine getMedicineById(int medicineId);
   
}
