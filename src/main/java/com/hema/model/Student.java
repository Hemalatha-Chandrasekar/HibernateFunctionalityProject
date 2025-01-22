package com.hema.model;
import java.util.Objects;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "findmajor", query = "from Student s where s.major = :major")

})
@Entity
@Table(name="student")
public class Student {
    @Column(name="studentId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;

    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.major = "";
    }
    public Student(String firstName, String lastName, String email, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getId() == student.getId() && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getMajor(), student.getMajor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getMajor());
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                '}';
    }


}
