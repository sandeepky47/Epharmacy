package com.spring.epharma.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Medicine {
	private int medicineId;
	@NotBlank
	private String medicineName;
	@NotBlank
	private String company;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufactureDate;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expireDate;
	@Range(min = 1, max = 5000, message = "Must be between 1 and 5000")
	private int amount;

	public Medicine() {

	}

	public Medicine(final int medicineId, @NotBlank final String medicineName, @NotBlank final String company,
			@NotNull final Date manufactureDate, @NotNull final Date expireDate,
			@Range(min = 1, max = 5000, message = "Must be between 1 and 5000") final int amount) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.company = company;
		this.manufactureDate = manufactureDate;
		this.expireDate = expireDate;
		this.amount = amount;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(final int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(final String medicineName) {
		this.medicineName = medicineName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(final String company) {
		this.company = company;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(final Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(final Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(final int amount) {
		this.amount = amount;
	}

}
