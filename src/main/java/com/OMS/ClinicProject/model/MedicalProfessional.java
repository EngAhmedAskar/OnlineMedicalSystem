package com.OMS.ClinicProject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MedicalProfessional")
public class MedicalProfessional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    private String name;


    @Column(name = "type")
    @NotEmpty(message = "*Please provide type")
    private String type;

    @Column(name = "mobile")
    @NotEmpty(message = "*Please provide mobile")
    private String mobile;

    @Column(name = "phone")
    @NotEmpty(message = "*Please provide phone")
    private String phone;

    @Column(name = "credential")
    @NotEmpty(message = "*Please provide credential")
    private String credential;

    @Column(name = "username")
    @NotEmpty(message = "*Please provide User Name")
    private String userName;

    @Column(name = "password")
    @NotEmpty(message = "*Please provide PassWord")
    private String passWord;

    @ManyToMany
    private List<Speciality> professionalSpecialityList;
<<<<<<< HEAD

    public MedicalProfessional() {
    }

    public MedicalProfessional(@NotEmpty(message = "*Please provide name") String name, @NotEmpty(message = "*Please provide type") String type, @NotEmpty(message = "*Please provide mobile") String mobile, @NotEmpty(message = "*Please provide phone") String phone, @NotEmpty(message = "*Please provide credential") String credential, @NotEmpty(message = "*Please provide User Name") String userName, @NotEmpty(message = "*Please provide PassWord") String passWord, List<Speciality> rofessionalSpecialityList) {
        this.name = name;
        this.type = type;
        this.mobile = mobile;
        this.phone = phone;
        this.credential = credential;
        this.userName = userName;
        this.passWord = passWord;
        this.professionalSpecialityList = rofessionalSpecialityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Speciality> getProfessionalSpecialityList() {
        return professionalSpecialityList;
    }

    public void setProfessionalSpecialityList(List<Speciality> professionalSpecialityList) {
        this.professionalSpecialityList = professionalSpecialityList;
    }
=======
>>>>>>> 0e745be523cb26c180544b229bb89de6402d58a1
}
