package com.example.visa;

public class VIsaInformation {

    private String fullname ;
    private String fullAddress ;
    private String country ;
    private String emailIdentification ;
    private String passportNumber;
    private String phoneNumber;
    private String gender ;
    private String dateofbirth ;
    private String dateofissue;
    private String validupto;
    private String pass;


    public VIsaInformation(String fullname, String fullAddress, String country, String emailIdentification, String passportNumber, String phoneNumber, String gender, String dateofbirth, String dateofissue, String validupto) {
        this.fullname = fullname;
        this.fullAddress = fullAddress;
        this.country = country;
        this.emailIdentification = emailIdentification;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.dateofissue = dateofissue;
        this.validupto = validupto;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getEmailIdentification() {
        return emailIdentification;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getDateofissue() {
        return dateofissue;
    }

    public String getValidupto() {
        return validupto;
    }

    public String getPass() {
        pass = "maybe";
        return pass;
    }
}
