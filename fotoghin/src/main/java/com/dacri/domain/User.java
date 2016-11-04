package com.dacri.domain;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private Date createdDate;
	private Date lastLogin;
	private Date lastAccess;
	private int accessedTimes;
	private int donor;
	private String resetCode;
	private String resetCodeDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
	public int getAccessedTimes() {
		return accessedTimes;
	}
	public void setAccessedTimes(int accessedTimes) {
		this.accessedTimes = accessedTimes;
	}
	public int getDonor() {
		return donor;
	}
	public void setDonor(int donor) {
		this.donor = donor;
	}
	public String getResetCode() {
		return resetCode;
	}
	public void setResetCode(String resetCode) {
		this.resetCode = resetCode;
	}
	public String getResetCodeDate() {
		return resetCodeDate;
	}
	public void setResetCodeDate(String resetCodeDate) {
		this.resetCodeDate = resetCodeDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", createdDate="
				+ createdDate + ", lastLogin=" + lastLogin + ", lastAccess=" + lastAccess + ", accessedTimes="
				+ accessedTimes + ", donor=" + donor + ", resetCode=" + resetCode + ", resetCodeDate=" + resetCodeDate
				+ "]";
	}
	public boolean isActivated() {
		return true;
	}
	
	public String getRole() {
		return "ROLE_USER";
	}
}