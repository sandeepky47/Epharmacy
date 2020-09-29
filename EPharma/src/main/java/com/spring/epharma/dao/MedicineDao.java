package com.spring.epharma.dao;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.spring.epharma.model.Medicine;

@Component
public class MedicineDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Medicine> getExpiredMedicine(final Date currentDate) {
		 String query = "select * from medicine where expiredate<=?";
		return jdbcTemplate.query(query,new Object[]{currentDate},
				(rs,rowNum) -> 
		       new Medicine(rs.getInt("medicine_id"),
				rs.getString("medicine_name"),
				rs.getString("company"),
				rs.getDate("manufacturedate"),
				rs.getDate("expiredate"),
				rs.getInt("amount"))
				);
		
	}
	
	public void addMedicine(final Medicine medicine) {
	final String query = "INSERT INTO medicine(medicine_name,company,manufacturedate,expiredate,amount)"+" VALUES (?,?,?,?,?)";
	
	jdbcTemplate.update(query,medicine.getMedicineName(),medicine.getCompany(),medicine.getManufactureDate(),
			medicine.getExpireDate(),medicine.getAmount());
	}
	
	public List<Medicine> getAllMedicine() {
		 String query = "select * from medicine";
		return jdbcTemplate.query(query,BeanPropertyRowMapper.newInstance(Medicine.class));
		
	}
	
	public void deleteMedicine(final int medicineId) {

		String query = "DELETE FROM medicine WHERE medicine_id=?";
		jdbcTemplate.update(query, medicineId);
	}
	
	public void editMedicine(final Medicine medicine) {
		String query = "UPDATE medicine SET medicine_name=?, company=?,manufacturedate=?,expiredate=?,amount=? WHERE medicine_id=?";
		jdbcTemplate.update(query,medicine.getMedicineName(),medicine.getCompany(),medicine.getManufactureDate(),medicine.getExpireDate(),medicine.getAmount(),medicine.getMedicineId());
	}
	
	public Medicine getMedicineById(final int medicineId) {

		String query = "select * from medicine where medicine_id=" + medicineId;
		return jdbcTemplate.queryForObject(query, BeanPropertyRowMapper.newInstance(Medicine.class));
     
	}
	
	


}
