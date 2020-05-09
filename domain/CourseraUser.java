package com.mochurad.coursera.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.mochurad.coursera.domain.enumeration.Sex;

/**
 * A CourseraUser.
 */
@Entity
@Table(name = "coursera_user")
public class CourseraUser implements Serializable {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @NotNull
    @Size(max = 50)
    @Column(name = "password", length = 50, nullable = false, unique = true)
    private String password;

    @Size(max = 1000)
    @Column(name = "bio", length = 1000)
    private String bio;

    @Size(max = 50)
    @Column(name = "country", length = 50)
    private String country;

    @Size(max = 255)
    @Column(name = "facebook_url", length = 255)
    private String facebookUrl;

    @Size(max = 255)
    @Column(name = "google_plus_url", length = 255)
    private String googlePlusUrl;

    @OneToMany(mappedBy = "user")
    private Set<UserVideo> userVideos = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserCourse> userCourses = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserInterestedProgram> userInterestedPrograms = new HashSet<>();

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

    public CourseraUser firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public CourseraUser surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public CourseraUser birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public CourseraUser sex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public CourseraUser username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public CourseraUser password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public CourseraUser bio(String bio) {
        this.bio = bio;
        return this;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCountry() {
        return country;
    }

    public CourseraUser country(String country) {
        this.country = country;
        return this;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public CourseraUser facebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
        return this;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getGooglePlusUrl() {
        return googlePlusUrl;
    }

    public CourseraUser googlePlusUrl(String googlePlusUrl) {
        this.googlePlusUrl = googlePlusUrl;
        return this;
    }

    public void setGooglePlusUrl(String googlePlusUrl) {
        this.googlePlusUrl = googlePlusUrl;
    }

    public Set<UserVideo> getUserVideos() {
        return userVideos;
    }

    public CourseraUser userVideos(Set<UserVideo> userVideos) {
        this.userVideos = userVideos;
        return this;
    }

    public CourseraUser addUserVideo(UserVideo userVideo) {
        this.userVideos.add(userVideo);
        userVideo.setUser(this);
        return this;
    }

    public CourseraUser removeUserVideo(UserVideo userVideo) {
        this.userVideos.remove(userVideo);
        userVideo.setUser(null);
        return this;
    }

    public void setUserVideos(Set<UserVideo> userVideos) {
        this.userVideos = userVideos;
    }

    public Set<UserCourse> getUserCourses() {
        return userCourses;
    }

    public CourseraUser userCourses(Set<UserCourse> userCourses) {
        this.userCourses = userCourses;
        return this;
    }

    public CourseraUser addUserCourse(UserCourse userCourse) {
        this.userCourses.add(userCourse);
        userCourse.setUser(this);
        return this;
    }

    public CourseraUser removeUserCourse(UserCourse userCourse) {
        this.userCourses.remove(userCourse);
        userCourse.setUser(null);
        return this;
    }

    public void setUserCourses(Set<UserCourse> userCourses) {
        this.userCourses = userCourses;
    }

    public Set<UserInterestedProgram> getUserInterestedPrograms() {
        return userInterestedPrograms;
    }

    public CourseraUser userInterestedPrograms(Set<UserInterestedProgram> userInterestedPrograms) {
        this.userInterestedPrograms = userInterestedPrograms;
        return this;
    }

    public CourseraUser addUserInterestedProgram(UserInterestedProgram userInterestedProgram) {
        this.userInterestedPrograms.add(userInterestedProgram);
        userInterestedProgram.setUser(this);
        return this;
    }

    public CourseraUser removeUserInterestedProgram(UserInterestedProgram userInterestedProgram) {
        this.userInterestedPrograms.remove(userInterestedProgram);
        userInterestedProgram.setUser(null);
        return this;
    }

    public void setUserInterestedPrograms(Set<UserInterestedProgram> userInterestedPrograms) {
        this.userInterestedPrograms = userInterestedPrograms;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseraUser)) {
            return false;
        }
        return id != null && id.equals(((CourseraUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CourseraUser{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", birthDate='" + getBirthDate() + "'" +
            ", sex='" + getSex() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", bio='" + getBio() + "'" +
            ", country='" + getCountry() + "'" +
            ", facebookUrl='" + getFacebookUrl() + "'" +
            ", googlePlusUrl='" + getGooglePlusUrl() + "'" +
            "}";
    }
}
