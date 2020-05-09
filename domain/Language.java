package com.mochurad.coursera.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Language.
 */
@Entity
@Table(name = "language")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @NotNull
    @Pattern(regexp = "[A-Z]{2}")
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "language")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "language")
    private Set<VideoTranscriptLanguage> videoTranscriptLanguages = new HashSet<>();

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

    public Language name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Language code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Language courses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }

    public Language addCourses(Course course) {
        this.courses.add(course);
        course.setLanguage(this);
        return this;
    }

    public Language removeCourses(Course course) {
        this.courses.remove(course);
        course.setLanguage(null);
        return this;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<VideoTranscriptLanguage> getVideoTranscriptLanguages() {
        return videoTranscriptLanguages;
    }

    public Language videoTranscriptLanguages(Set<VideoTranscriptLanguage> videoTranscriptLanguages) {
        this.videoTranscriptLanguages = videoTranscriptLanguages;
        return this;
    }

    public Language addVideoTranscriptLanguage(VideoTranscriptLanguage videoTranscriptLanguage) {
        this.videoTranscriptLanguages.add(videoTranscriptLanguage);
        videoTranscriptLanguage.setLanguage(this);
        return this;
    }

    public Language removeVideoTranscriptLanguage(VideoTranscriptLanguage videoTranscriptLanguage) {
        this.videoTranscriptLanguages.remove(videoTranscriptLanguage);
        videoTranscriptLanguage.setLanguage(null);
        return this;
    }

    public void setVideoTranscriptLanguages(Set<VideoTranscriptLanguage> videoTranscriptLanguages) {
        this.videoTranscriptLanguages = videoTranscriptLanguages;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Language)) {
            return false;
        }
        return id != null && id.equals(((Language) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Language{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
}
