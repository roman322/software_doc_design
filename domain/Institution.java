package com.mochurad.coursera.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Institution.
 */
@Entity
@Table(name = "institution")
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(max = 255)
    @Column(name = "location", length = 255, nullable = false)
    private String location;

    @Size(max = 1000)
    @Column(name = "about", length = 1000)
    private String about;

    @OneToMany(mappedBy = "createdBy")
    private Set<Program> programs = new HashSet<>();

    @OneToMany(mappedBy = "institution")
    private Set<Instructor> instructors = new HashSet<>();

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

    public Institution name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public Institution location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAbout() {
        return about;
    }

    public Institution about(String about) {
        this.about = about;
        return this;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Program> getPrograms() {
        return programs;
    }

    public Institution programs(Set<Program> programs) {
        this.programs = programs;
        return this;
    }

    public Institution addPrograms(Program program) {
        this.programs.add(program);
        program.setCreatedBy(this);
        return this;
    }

    public Institution removePrograms(Program program) {
        this.programs.remove(program);
        program.setCreatedBy(null);
        return this;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public Institution instructors(Set<Instructor> instructors) {
        this.instructors = instructors;
        return this;
    }

    public Institution addInstructors(Instructor instructor) {
        this.instructors.add(instructor);
        instructor.setInstitution(this);
        return this;
    }

    public Institution removeInstructors(Instructor instructor) {
        this.instructors.remove(instructor);
        instructor.setInstitution(null);
        return this;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Institution)) {
            return false;
        }
        return id != null && id.equals(((Institution) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Institution{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", location='" + getLocation() + "'" +
            ", about='" + getAbout() + "'" +
            "}";
    }
}
