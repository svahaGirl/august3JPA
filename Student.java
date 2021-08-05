package com.perscholas.august3.student;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
//import javax.persistence.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Slf4j
@Table
public class Student {
  /*  @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize= 1
    )*/



    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
           // generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private LocalDate dob;

    @Transient // no more column in database, is generated value.
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name, String email, LocalDate dob ) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        // generate age
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
