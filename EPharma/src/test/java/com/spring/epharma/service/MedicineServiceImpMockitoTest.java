package com.spring.epharma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.spring.epharma.dao.MedicineDao;
import com.spring.epharma.model.Medicine;

@RunWith(MockitoJUnitRunner.class)
public class MedicineServiceImpMockitoTest {

	@Mock
	private MedicineDao medicinedao;
	
	 @InjectMocks
	private MedicineService mediservice=new MedicineServiceImp();
	 
	
		 final Medicine mediOne = new Medicine(105,"Zinase-A","Cipla",java.sql.Date.valueOf("2019-01-23"),java.sql.Date.valueOf("2020-11-24"),400);
			final Medicine mediTwo = new Medicine(106,"Zinase-D","Abbot India",java.sql.Date.valueOf("2018-05-15"),java.sql.Date.valueOf("2020-12-12"),200);
			 List<Medicine> list = new ArrayList<Medicine>();
		    
	 @Test()
	 public void getExpiredCustomerTest() {
		 list.add(mediOne);
	     list.add(mediTwo); 
	        when(medicinedao.getExpiredMedicine(java.sql.Date.valueOf("2019-01-23"))).thenReturn(list);
	    
	        List<Medicine> mediList = mediservice.getExpiredMedicine(java.sql.Date.valueOf("2019-01-23")); 
	        assertEquals(2, mediList.size());
	        verify(medicinedao, times(1)).getExpiredMedicine(java.sql.Date.valueOf("2019-01-23"));
	        
		 
	 }
	 
	 @Test
	    public void addMedicineTest()
	    {
	        mediservice.addMedicine(mediOne);
	         verify(medicinedao, times(1)).addMedicine(mediOne);
	    }
	 @Test
	 public void getMedicineByIdTest() {
		 when(medicinedao.getMedicineById(106)).thenReturn(mediTwo);
		 assertEquals("Zinase-D",mediservice.getMedicineById(106).getMedicineName());
		 verify(medicinedao, times(1)).getMedicineById(106);
		 
	 }
	 @Test
	 public void getAllMedicineTest() {
		 list.add(mediOne);
	     list.add(mediTwo);
		 when(medicinedao.getAllMedicine()).thenReturn(list);
		 assertEquals(2,mediservice.getAllMedicine().size());
		 verify(medicinedao, times(1)).getAllMedicine();
	 }
	 @Test
	    public void deleteMedicineTest()
	    {
	        mediservice.deleteMedicine(108);
	         verify(medicinedao, times(1)).deleteMedicine(108);
	    }
	 @Test
	    public void editMedicineTest()
	    {
	        mediservice.editMedicine(mediOne);
	         verify(medicinedao, times(1)).editMedicine(mediOne);
	    }

}
