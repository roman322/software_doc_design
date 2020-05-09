package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.InstructorService;
import com.mochurad.coursera.domain.Instructor;
import com.mochurad.coursera.repository.InstructorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Instructor}.
 */
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private final Logger log = LoggerFactory.getLogger(InstructorServiceImpl.class);

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    /**
     * Save a instructor.
     *
     * @param instructor the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Instructor save(Instructor instructor) {
        log.debug("Request to save Instructor : {}", instructor);
        return instructorRepository.save(instructor);
    }

    /**
     * Get all the instructors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Instructor> findAll(Pageable pageable) {
        log.debug("Request to get all Instructors");
        return instructorRepository.findAll(pageable);
    }

    /**
     * Get all the instructors with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<Instructor> findAllWithEagerRelationships(Pageable pageable) {
        return instructorRepository.findAllWithEagerRelationships(pageable);
    }

    /**
     * Get one instructor by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Instructor> findOne(Long id) {
        log.debug("Request to get Instructor : {}", id);
        return instructorRepository.findOneWithEagerRelationships(id);
    }

    /**
     * Delete the instructor by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Instructor : {}", id);
        instructorRepository.deleteById(id);
    }
}
