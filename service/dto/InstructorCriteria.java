package com.mochurad.coursera.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link com.mochurad.coursera.domain.Instructor} entity. This class is used
 * in {@link com.mochurad.coursera.web.rest.InstructorResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /instructors?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InstructorCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter firstName;

    private StringFilter surname;

    private LocalDateFilter birthDate;

    private StringFilter position;

    private StringFilter bio;

    private LongFilter coursesId;

    private LongFilter institutionId;

    public InstructorCriteria() {
    }

    public InstructorCriteria(InstructorCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.surname = other.surname == null ? null : other.surname.copy();
        this.birthDate = other.birthDate == null ? null : other.birthDate.copy();
        this.position = other.position == null ? null : other.position.copy();
        this.bio = other.bio == null ? null : other.bio.copy();
        this.coursesId = other.coursesId == null ? null : other.coursesId.copy();
        this.institutionId = other.institutionId == null ? null : other.institutionId.copy();
    }

    @Override
    public InstructorCriteria copy() {
        return new InstructorCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getSurname() {
        return surname;
    }

    public void setSurname(StringFilter surname) {
        this.surname = surname;
    }

    public LocalDateFilter getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateFilter birthDate) {
        this.birthDate = birthDate;
    }

    public StringFilter getPosition() {
        return position;
    }

    public void setPosition(StringFilter position) {
        this.position = position;
    }

    public StringFilter getBio() {
        return bio;
    }

    public void setBio(StringFilter bio) {
        this.bio = bio;
    }

    public LongFilter getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(LongFilter coursesId) {
        this.coursesId = coursesId;
    }

    public LongFilter getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(LongFilter institutionId) {
        this.institutionId = institutionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InstructorCriteria that = (InstructorCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(surname, that.surname) &&
            Objects.equals(birthDate, that.birthDate) &&
            Objects.equals(position, that.position) &&
            Objects.equals(bio, that.bio) &&
            Objects.equals(coursesId, that.coursesId) &&
            Objects.equals(institutionId, that.institutionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        firstName,
        surname,
        birthDate,
        position,
        bio,
        coursesId,
        institutionId
        );
    }

    @Override
    public String toString() {
        return "InstructorCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (surname != null ? "surname=" + surname + ", " : "") +
                (birthDate != null ? "birthDate=" + birthDate + ", " : "") +
                (position != null ? "position=" + position + ", " : "") +
                (bio != null ? "bio=" + bio + ", " : "") +
                (coursesId != null ? "coursesId=" + coursesId + ", " : "") +
                (institutionId != null ? "institutionId=" + institutionId + ", " : "") +
            "}";
    }

}
