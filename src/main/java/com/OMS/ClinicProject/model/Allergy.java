package com.OMS.ClinicProject.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    @NotEmpty(message = "*Please provide description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Allergy(){

    }
    public Allergy(@NotEmpty(message = "*Please provide description") String description){
        this.description = description;
    }
    @ManyToMany
    private List<Patient> myPatientAllergy;
}
