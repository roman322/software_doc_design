package com.mochurad.coursera.service;

import com.mochurad.coursera.domain.Instructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Instructor}.
 */
public interface InstructorService {

    /**
     * Save a instructor.
     *
     * @param instructor the entity to save.
     * @return the persisted entity.
     */
    Instructor save(Instructor instructor);

    /**
     * Get all the instructors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Instructor> findAll(Pageable pageable);

    /**
     * Get all the instructors with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<Instructor> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" instructor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Instructor> findOne(Long id);

    /**
     * Delete the "id" instructor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
