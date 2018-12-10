package com.katariasoft.technologies.jpaHibernate.college.data.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_tbl")
public class Instructor {

	@Id
	private int id;
	@Column(length = 64, nullable = false)
	private String name;
	@Column(length = 64, nullable = false)
	private String fatherName;
	@Column(length = 64)
	private String motherName;
	@Column(length = 1000, nullable = false)
	private String address;
	@Column(nullable = false, name = "monthly_salary", scale = 2, precision = 9)
	private BigDecimal salary;
	@Column(nullable = false)
	private LocalDate birthDate;
	@Column(nullable = false)
	private LocalTime dayStartTime;
	@Column(nullable = false)
	private LocalTime dayOffTime;
	@Column(nullable = false)
	private LocalDateTime createdDate;
	@Column(nullable = false)
	private LocalDateTime updatedDate;

	public Instructor() {
	}

	public Instructor(String name, String fatherName, String motherName, String address, BigDecimal salary,
			LocalDate birthDate, LocalTime dayStartTime, LocalTime dayOffTime, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.salary = salary;
		this.birthDate = birthDate;
		this.dayStartTime = dayStartTime;
		this.dayOffTime = dayOffTime;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalTime getDayStartTime() {
		return dayStartTime;
	}

	public void setDayStartTime(LocalTime dayStartTime) {
		this.dayStartTime = dayStartTime;
	}

	public LocalTime getDayOffTime() {
		return dayOffTime;
	}

	public void setDayOffTime(LocalTime dayOffTime) {
		this.dayOffTime = dayOffTime;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
