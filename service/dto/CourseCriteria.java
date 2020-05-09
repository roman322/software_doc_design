package com.mochurad.coursera.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.mochurad.coursera.domain.enumeration.Subject;
import com.mochurad.coursera.domain.enumeration.Level;
import com.mochurad.coursera.domain.enumeration.Availability;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link com.mochurad.coursera.domain.Course} entity. This class is used
 * in {@link com.mochurad.coursera.web.rest.CourseResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /courses?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CourseCriteria implements Serializable, Criteria {
    /**
     * Class for filtering Subject
     */
    public static class SubjectFilter extends Filter<Subject> {

        public SubjectFilter() {
        }

        public SubjectFilter(SubjectFilter filter) {
            super(filter);
        }

        @Override
        public SubjectFilter copy() {
            return new SubjectFilter(this);
        }

    }
    /**
     * Class for filtering Level
     */
    public static class LevelFilter extends Filter<Level> {

        public LevelFilter() {
        }

        public LevelFilter(LevelFilter filter) {
            super(filter);
        }

        @Override
        public LevelFilter copy() {
            return new LevelFilter(this);
        }

    }
    /**
     * Class for filtering Availability
     */
    public static class AvailabilityFilter extends Filter<Availability> {

        public AvailabilityFilter() {
        }

        public AvailabilityFilter(AvailabilityFilter filter) {
            super(filter);
        }

        @Override
        public AvailabilityFilter copy() {
            return new AvailabilityFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private IntegerFilter durationInWeeks;

    private StringFilter description;

    private DoubleFilter price;

    private SubjectFilter subject;

    private LevelFilter level;

    private AvailabilityFilter availability;

    private ZonedDateTimeFilter startDate;

    private ZonedDateTimeFilter finishDate;

    private LongFilter videosId;

    private LongFilter userCourseId;

    private LongFilter associatedProgramId;

    private LongFilter languageId;

    private LongFilter instructorsId;

    public CourseCriteria() {
    }

    public CourseCriteria(CourseCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.durationInWeeks = other.durationInWeeks == null ? null : other.durationInWeeks.copy();
        this.description = other.description == null ? null : other.description.copy();
        this.price = other.price == null ? null : other.price.copy();
        this.subject = other.subject == null ? null : other.subject.copy();
        this.level = other.level == null ? null : other.level.copy();
        this.availability = other.availability == null ? null : other.availability.copy();
        this.startDate = other.startDate == null ? null : other.startDate.copy();
        this.finishDate = other.finishDate == null ? null : other.finishDate.copy();
        this.videosId = other.videosId == null ? null : other.videosId.copy();
        this.userCourseId = other.userCourseId == null ? null : other.userCourseId.copy();
        this.associatedProgramId = other.associatedProgramId == null ? null : other.associatedProgramId.copy();
        this.languageId = other.languageId == null ? null : other.languageId.copy();
        this.instructorsId = other.instructorsId == null ? null : other.instructorsId.copy();
    }

    @Override
    public CourseCriteria copy() {
        return new CourseCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public IntegerFilter getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(IntegerFilter durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public StringFilter getDescription() {
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public DoubleFilter getPrice() {
        return price;
    }

    public void setPrice(DoubleFilter price) {
        this.price = price;
    }

    public SubjectFilter getSubject() {
        return subject;
    }

    public void setSubject(SubjectFilter subject) {
        this.subject = subject;
    }

    public LevelFilter getLevel() {
        return level;
    }

    public void setLevel(LevelFilter level) {
        this.level = level;
    }

    public AvailabilityFilter getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityFilter availability) {
        this.availability = availability;
    }

    public ZonedDateTimeFilter getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTimeFilter startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTimeFilter getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(ZonedDateTimeFilter finishDate) {
        this.finishDate = finishDate;
    }

    public LongFilter getVideosId() {
        return videosId;
    }

    public void setVideosId(LongFilter videosId) {
        this.videosId = videosId;
    }

    public LongFilter getUserCourseId() {
        return userCourseId;
    }

    public void setUserCourseId(LongFilter userCourseId) {
        this.userCourseId = userCourseId;
    }

    public LongFilter getAssociatedProgramId() {
        return associatedProgramId;
    }

    public void setAssociatedProgramId(LongFilter associatedProgramId) {
        this.associatedProgramId = associatedProgramId;
    }

    public LongFilter getLanguageId() {
        return languageId;
    }

    public void setLanguageId(LongFilter languageId) {
        this.languageId = languageId;
    }

    public LongFilter getInstructorsId() {
        return instructorsId;
    }

    public void setInstructorsId(LongFilter instructorsId) {
        this.instructorsId = instructorsId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CourseCriteria that = (CourseCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(durationInWeeks, that.durationInWeeks) &&
            Objects.equals(description, that.description) &&
            Objects.equals(price, that.price) &&
            Objects.equals(subject, that.subject) &&
            Objects.equals(level, that.level) &&
            Objects.equals(availability, that.availability) &&
            Objects.equals(startDate, that.startDate) &&
            Objects.equals(finishDate, that.finishDate) &&
            Objects.equals(videosId, that.videosId) &&
            Objects.equals(userCourseId, that.userCourseId) &&
            Objects.equals(associatedProgramId, that.associatedProgramId) &&
            Objects.equals(languageId, that.languageId) &&
            Objects.equals(instructorsId, that.instructorsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        name,
        durationInWeeks,
        description,
        price,
        subject,
        level,
        availability,
        startDate,
        finishDate,
        videosId,
        userCourseId,
        associatedProgramId,
        languageId,
        instructorsId
        );
    }

    @Override
    public String toString() {
        return "CourseCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
                (durationInWeeks != null ? "durationInWeeks=" + durationInWeeks + ", " : "") +
                (description != null ? "description=" + description + ", " : "") +
                (price != null ? "price=" + price + ", " : "") +
                (subject != null ? "subject=" + subject + ", " : "") +
                (level != null ? "level=" + level + ", " : "") +
                (availability != null ? "availability=" + availability + ", " : "") +
                (startDate != null ? "startDate=" + startDate + ", " : "") +
                (finishDate != null ? "finishDate=" + finishDate + ", " : "") +
                (videosId != null ? "videosId=" + videosId + ", " : "") +
                (userCourseId != null ? "userCourseId=" + userCourseId + ", " : "") +
                (associatedProgramId != null ? "associatedProgramId=" + associatedProgramId + ", " : "") +
                (languageId != null ? "languageId=" + languageId + ", " : "") +
                (instructorsId != null ? "instructorsId=" + instructorsId + ", " : "") +
            "}";
    }

}
