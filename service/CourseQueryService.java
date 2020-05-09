package com.mochurad.coursera.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.mochurad.coursera.domain.Course;
import com.mochurad.coursera.domain.*; // for static metamodels
import com.mochurad.coursera.repository.CourseRepository;
import com.mochurad.coursera.service.dto.CourseCriteria;

/**
 * Service for executing complex queries for {@link Course} entities in the database.
 * The main input is a {@link CourseCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Course} or a {@link Page} of {@link Course} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CourseQueryService extends QueryService<Course> {

    private final Logger log = LoggerFactory.getLogger(CourseQueryService.class);

    private final CourseRepository courseRepository;

    public CourseQueryService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Return a {@link List} of {@link Course} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Course> findByCriteria(CourseCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Course> specification = createSpecification(criteria);
        return courseRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Course} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Course> findByCriteria(CourseCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Course> specification = createSpecification(criteria);
        return courseRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CourseCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Course> specification = createSpecification(criteria);
        return courseRepository.count(specification);
    }

    /**
     * Function to convert {@link CourseCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Course> createSpecification(CourseCriteria criteria) {
        Specification<Course> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Course_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Course_.name));
            }
            if (criteria.getDurationInWeeks() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDurationInWeeks(), Course_.durationInWeeks));
            }
            if (criteria.getDescription() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDescription(), Course_.description));
            }
            if (criteria.getPrice() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getPrice(), Course_.price));
            }
            if (criteria.getSubject() != null) {
                specification = specification.and(buildSpecification(criteria.getSubject(), Course_.subject));
            }
            if (criteria.getLevel() != null) {
                specification = specification.and(buildSpecification(criteria.getLevel(), Course_.level));
            }
            if (criteria.getAvailability() != null) {
                specification = specification.and(buildSpecification(criteria.getAvailability(), Course_.availability));
            }
            if (criteria.getStartDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getStartDate(), Course_.startDate));
            }
            if (criteria.getFinishDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getFinishDate(), Course_.finishDate));
            }
            if (criteria.getVideosId() != null) {
                specification = specification.and(buildSpecification(criteria.getVideosId(),
                    root -> root.join(Course_.videos, JoinType.LEFT).get(Video_.id)));
            }
            if (criteria.getUserCourseId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserCourseId(),
                    root -> root.join(Course_.userCourses, JoinType.LEFT).get(UserCourse_.id)));
            }
            if (criteria.getAssociatedProgramId() != null) {
                specification = specification.and(buildSpecification(criteria.getAssociatedProgramId(),
                    root -> root.join(Course_.associatedProgram, JoinType.LEFT).get(Program_.id)));
            }
            if (criteria.getLanguageId() != null) {
                specification = specification.and(buildSpecification(criteria.getLanguageId(),
                    root -> root.join(Course_.language, JoinType.LEFT).get(Language_.id)));
            }
            if (criteria.getInstructorsId() != null) {
                specification = specification.and(buildSpecification(criteria.getInstructorsId(),
                    root -> root.join(Course_.instructors, JoinType.LEFT).get(Instructor_.id)));
            }
        }
        return specification;
    }
}
