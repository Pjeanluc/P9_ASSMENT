package com.ocr.axa.jlp.assessment.model.Dto;

import java.time.LocalDate;

public class Patient {

    private long id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String genre;
    private String address;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(long id, String firstname, String lastname, LocalDate birthdate, String sex) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.genre = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return genre;
    }

    public void setSex(String sex) {
        this.genre = sex;
    }
}
