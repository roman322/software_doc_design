package com.mochurad.coursera.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Instructor.
 */
@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "first_name", length = 100, nullable = false, unique = true)
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "surname", length = 100, nullable = false, unique = true)
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Size(max = 100)
    @Column(name = "position", length = 100)
    private String position;

    @Size(max = 1000)
    @Column(name = "bio", length = 1000)
    private String bio;

    @ManyToMany
    @JoinTable(name = "instructor_courses",
               joinColumns = @JoinColumn(name = "instructor_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "courses_id", referencedColumnName = "id"))
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("instructors")
    private Institution institution;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Instructor firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Instructor surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Instructor birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public Instructor position(String position) {
        this.position = position;
        return this;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBio() {
        return bio;
    }

    public Instructor bio(String bio) {
        this.bio = bio;
        return this;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Instructor courses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }

    public Instructor addCourses(Course course) {
        this.courses.add(course);
        course.getInstructors().add(this);
        return this;
    }

    public Instructor removeCourses(Course course) {
        this.courses.remove(course);
        course.getInstructors().remove(this);
        return this;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Instructor institution(Institution institution) {
        this.institution = institution;
        return this;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Instructor)) {
            return false;
        }
        return id != null && id.equals(((Instructor) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Instructor{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", position='" + getPosition() + "'" +
            ", bio='" + getBio() + "'" +
            "}";
    }
}
