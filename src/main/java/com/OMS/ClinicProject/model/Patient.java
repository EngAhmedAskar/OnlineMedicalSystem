package com.OMS.ClinicProject.model;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    private String name;

    @Column(name = "address")
    @NotEmpty(message = "*Please provide address")
    private String address;

    @Column(name = "mobile")
    @NotEmpty(message = "*Please provide mobile")
    private String mobile;

    @Column(name = "phone")
    @NotEmpty(message = "*Please provide phone")
    private String phone;

    @Column(name = "username")
    @NotEmpty(message = "*Please provide username")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "*Please provide password")
    private String password;

    @Column(name = "email")
    @NotEmpty(message = "*Please provide email")
    private String email;

    @OneToMany
    @JoinTable(name = "MedicalHistoryItem")
    List<MedicalHistoryItem> medicalHistoryItems ;
}
