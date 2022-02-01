package com.example.ehospital;

public class PatientTableModel {
    private String firstName,LastName,email,mobileNo,PhoneNo,address,gender,bloodGroup,dob,createDate,status;
    private int serialNo;

    public PatientTableModel() {
    }

    public PatientTableModel(String firstName, String lastName, String email, String mobileNo, String phoneNo, String address, String gender, String bloodGroup, String dob, String createDate, String status, int serialNo) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
        PhoneNo = phoneNo;
        this.address = address;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
        this.createDate = createDate;
        this.status = status;
        this.serialNo = serialNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
}
