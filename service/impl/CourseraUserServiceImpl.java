package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.CourseraUserService;
import com.mochurad.coursera.domain.CourseraUser;
import com.mochurad.coursera.repository.CourseraUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link CourseraUser}.
 */
@Service
@Transactional
public class CourseraUserServiceImpl implements CourseraUserService {

    private final Logger log = LoggerFactory.getLogger(CourseraUserServiceImpl.class);

    private final CourseraUserRepository courseraUserRepository;

    public CourseraUserServiceImpl(CourseraUserRepository courseraUserRepository) {
        this.courseraUserRepository = courseraUserRepository;
    }

    /**
     * Save a courseraUser.
     *
     * @param courseraUser the entity to save.
     * @return the persisted entity.
     */
    @Override
    public CourseraUser save(CourseraUser courseraUser) {
        log.debug("Request to save CourseraUser : {}", courseraUser);
        return courseraUserRepository.save(courseraUser);
    }

    /**
     * Get all the courseraUsers.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CourseraUser> findAll() {
        log.debug("Request to get all CourseraUsers");
        return courseraUserRepository.findAll();
    }

    /**
     * Get one courseraUser by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CourseraUser> findOne(Long id) {
        log.debug("Request to get CourseraUser : {}", id);
        return courseraUserRepository.findById(id);
    }

    /**
     * Delete the courseraUser by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CourseraUser : {}", id);
        courseraUserRepository.deleteById(id);
    }
}
