package com.mochurad.coursera.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Program.
 */
@Entity
@Table(name = "program")
public class Program implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "duration_in_months")
    private Integer durationInMonths;

    @OneToMany(mappedBy = "associatedProgram")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "program")
    private Set<UserInterestedProgram> userInterestedPrograms = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("programs")
    private Institution createdBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Program name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Program description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public Program price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public Program durationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
        return this;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Program courses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }

    public Program addCourses(Course course) {
        this.courses.add(course);
        course.setAssociatedProgram(this);
        return this;
    }

    public Program removeCourses(Course course) {
        this.courses.remove(course);
        course.setAssociatedProgram(null);
        return this;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<UserInterestedProgram> getUserInterestedPrograms() {
        return userInterestedPrograms;
    }

    public Program userInterestedPrograms(Set<UserInterestedProgram> userInterestedPrograms) {
        this.userInterestedPrograms = userInterestedPrograms;
        return this;
    }

    public Program addUserInterestedProgram(UserInterestedProgram userInterestedProgram) {
        this.userInterestedPrograms.add(userInterestedProgram);
        userInterestedProgram.setProgram(this);
        return this;
    }

    public Program removeUserInterestedProgram(UserInterestedProgram userInterestedProgram) {
        this.userInterestedPrograms.remove(userInterestedProgram);
        userInterestedProgram.setProgram(null);
        return this;
    }

    public void setUserInterestedPrograms(Set<UserInterestedProgram> userInterestedPrograms) {
        this.userInterestedPrograms = userInterestedPrograms;
    }

    public Institution getCreatedBy() {
        return createdBy;
    }

    public Program createdBy(Institution institution) {
        this.createdBy = institution;
        return this;
    }

    public void setCreatedBy(Institution institution) {
        this.createdBy = institution;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Program)) {
            return false;
        }
        return id != null && id.equals(((Program) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Program{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", durationInMonths=" + getDurationInMonths() +
            "}";
    }
}
