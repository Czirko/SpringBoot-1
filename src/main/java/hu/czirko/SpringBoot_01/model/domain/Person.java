package hu.czirko.SpringBoot_01.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@ApiModel(description = "Dummy Details abaut Person.")
public class Person {
    private Integer id;
    @Size(min = 2, message = "Name should be at least 2 characters")
    @ApiModelProperty(notes = "Name should be at least 2 characters")
    private String name;
    @Past
    @ApiModelProperty(notes = "Birthdate should be in the past")
    private LocalDate dob;


    public Person() {
    }

    public Person(Integer id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Person(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}
