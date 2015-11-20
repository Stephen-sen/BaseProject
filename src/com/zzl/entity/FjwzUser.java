package com.zzl.entity;

/**
 * FjwzUser entity. @author MyEclipse Persistence Tools
 */

public class FjwzUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userAccount;
	private String userPassword;
	private String userDepartment;
	private String userPosition;
	private String userName;
	private Integer userState;
	private String userSex;
	private Integer userDelete;
	private Integer userRoleid;
	private String userAge;
	private String userAddress;
	private String userEmail;
	private String userPhone;
	private String userRemark;

	// Constructors

	/** default constructor */
	public FjwzUser() {
	}

	/** minimal constructor */
	public FjwzUser(String userAccount, String userPassword, String userName,
			Integer userState, Integer userRoleid) {
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userState = userState;
		this.userRoleid = userRoleid;
	}

	/** full constructor */
	public FjwzUser(String userAccount, String userPassword,
			String userDepartment, String userPosition, String userName,
			Integer userState, String userSex, Integer userDelete,
			Integer userRoleid, String userAge, String userAddress,
			String userEmail, String userPhone, String userRemark) {
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userDepartment = userDepartment;
		this.userPosition = userPosition;
		this.userName = userName;
		this.userState = userState;
		this.userSex = userSex;
		this.userDelete = userDelete;
		this.userRoleid = userRoleid;
		this.userAge = userAge;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userRemark = userRemark;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserDepartment() {
		return this.userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserPosition() {
		return this.userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserDelete() {
		return this.userDelete;
	}

	public void setUserDelete(Integer userDelete) {
		this.userDelete = userDelete;
	}

	public Integer getUserRoleid() {
		return this.userRoleid;
	}

	public void setUserRoleid(Integer userRoleid) {
		this.userRoleid = userRoleid;
	}

	public String getUserAge() {
		return this.userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRemark() {
		return this.userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

}