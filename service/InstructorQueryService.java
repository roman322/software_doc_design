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

import com.mochurad.coursera.domain.Instructor;
import com.mochurad.coursera.domain.*; // for static metamodels
import com.mochurad.coursera.repository.InstructorRepository;
import com.mochurad.coursera.service.dto.InstructorCriteria;

/**
 * Service for executing complex queries for {@link Instructor} entities in the database.
 * The main input is a {@link InstructorCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Instructor} or a {@link Page} of {@link Instructor} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class InstructorQueryService extends QueryService<Instructor> {

    private final Logger log = LoggerFactory.getLogger(InstructorQueryService.class);

    private final InstructorRepository instructorRepository;

    public InstructorQueryService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    /**
     * Return a {@link List} of {@link Instructor} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Instructor> findByCriteria(InstructorCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Instructor> specification = createSpecification(criteria);
        return instructorRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Instructor} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Instructor> findByCriteria(InstructorCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Instructor> specification = createSpecification(criteria);
        return instructorRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(InstructorCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Instructor> specification = createSpecification(criteria);
        return instructorRepository.count(specification);
    }

    /**
     * Function to convert {@link InstructorCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Instructor> createSpecification(InstructorCriteria criteria) {
        Specification<Instructor> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Instructor_.id));
            }
            if (criteria.getFirstName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFirstName(), Instructor_.firstName));
            }
            if (criteria.getSurname() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSurname(), Instructor_.surname));
            }
            if (criteria.getBirthDate() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getBirthDate(), Instructor_.birthDate));
            }
            if (criteria.getPosition() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPosition(), Instructor_.position));
            }
            if (criteria.getBio() != null) {
                specification = specification.and(buildStringSpecification(criteria.getBio(), Instructor_.bio));
            }
            if (criteria.getCoursesId() != null) {
                specification = specification.and(buildSpecification(criteria.getCoursesId(),
                    root -> root.join(Instructor_.courses, JoinType.LEFT).get(Course_.id)));
            }
            if (criteria.getInstitutionId() != null) {
                specification = specification.and(buildSpecification(criteria.getInstitutionId(),
                    root -> root.join(Instructor_.institution, JoinType.LEFT).get(Institution_.id)));
            }
        }
        return specification;
    }
}
