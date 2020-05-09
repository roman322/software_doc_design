package com.mochurad.coursera.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

import com.mochurad.coursera.domain.enumeration.Subject;

import com.mochurad.coursera.domain.enumeration.Level;

import com.mochurad.coursera.domain.enumeration.Availability;

/**
 * A Course.
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "duration_in_weeks")
    private Integer durationInWeeks;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private Subject subject;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private Level level;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability")
    private Availability availability;

    @Column(name = "start_date")
    private ZonedDateTime startDate;

    @Column(name = "finish_date")
    private ZonedDateTime finishDate;

    @OneToMany(mappedBy = "associatedCourse")
    private Set<Video> videos = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private Set<UserCourse> userCourses = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("courses")
    private Program associatedProgram;

    @ManyToOne
    @JsonIgnoreProperties("courses")
    private Language language;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
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

    public Course name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDurationInWeeks() {
        return durationInWeeks;
    }

    public Course durationInWeeks(Integer durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
        return this;
    }

    public void setDurationInWeeks(Integer durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public String getDescription() {
        return description;
    }

    public Course description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public Course price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Subject getSubject() {
        return subject;
    }

    public Course subject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Level getLevel() {
        return level;
    }

    public Course level(Level level) {
        this.level = level;
        return this;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Course availability(Availability availability) {
        this.availability = availability;
        return this;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public Course startDate(ZonedDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getFinishDate() {
        return finishDate;
    }

    public Course finishDate(ZonedDateTime finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public void setFinishDate(ZonedDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public Course videos(Set<Video> videos) {
        this.videos = videos;
        return this;
    }

    public Course addVideos(Video video) {
        this.videos.add(video);
        video.setAssociatedCourse(this);
        return this;
    }

    public Course removeVideos(Video video) {
        this.videos.remove(video);
        video.setAssociatedCourse(null);
        return this;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public Set<UserCourse> getUserCourses() {
        return userCourses;
    }

    public Course userCourses(Set<UserCourse> userCourses) {
        this.userCourses = userCourses;
        return this;
    }

    public Course addUserCourse(UserCourse userCourse) {
        this.userCourses.add(userCourse);
        userCourse.setCourse(this);
        return this;
    }

    public Course removeUserCourse(UserCourse userCourse) {
        this.userCourses.remove(userCourse);
        userCourse.setCourse(null);
        return this;
    }

    public void setUserCourses(Set<UserCourse> userCourses) {
        this.userCourses = userCourses;
    }

    public Program getAssociatedProgram() {
        return associatedProgram;
    }

    public Course associatedProgram(Program program) {
        this.associatedProgram = program;
        return this;
    }

    public void setAssociatedProgram(Program program) {
        this.associatedProgram = program;
    }

    public Language getLanguage() {
        return language;
    }

    public Course language(Language language) {
        this.language = language;
        return this;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public Course instructors(Set<Instructor> instructors) {
        this.instructors = instructors;
        return this;
    }

    public Course addInstructors(Instructor instructor) {
        this.instructors.add(instructor);
        instructor.getCourses().add(this);
        return this;
    }

    public Course removeInstructors(Instructor instructor) {
        this.instructors.remove(instructor);
        instructor.getCourses().remove(this);
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
        if (!(o instanceof Course)) {
            return false;
        }
        return id != null && id.equals(((Course) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", durationInWeeks=" + getDurationInWeeks() +
            ", description='" + getDescription() + "'" +
            ", price=" + getPrice() +
            ", subject='" + getSubject() + "'" +
            ", level='" + getLevel() + "'" +
            ", availability='" + getAvailability() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", finishDate='" + getFinishDate() + "'" +
            "}";
    }
}
