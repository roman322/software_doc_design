package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.UserCourseService;
import com.mochurad.coursera.domain.UserCourse;
import com.mochurad.coursera.repository.UserCourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link UserCourse}.
 */
@Service
@Transactional
public class UserCourseServiceImpl implements UserCourseService {

    private final Logger log = LoggerFactory.getLogger(UserCourseServiceImpl.class);

    private final UserCourseRepository userCourseRepository;

    public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
        this.userCourseRepository = userCourseRepository;
    }

    /**
     * Save a userCourse.
     *
     * @param userCourse the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UserCourse save(UserCourse userCourse) {
        log.debug("Request to save UserCourse : {}", userCourse);
        return userCourseRepository.save(userCourse);
    }

    /**
     * Get all the userCourses.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserCourse> findAll() {
        log.debug("Request to get all UserCourses");
        return userCourseRepository.findAll();
    }

    /**
     * Get one userCourse by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserCourse> findOne(Long id) {
        log.debug("Request to get UserCourse : {}", id);
        return userCourseRepository.findById(id);
    }

    /**
     * Delete the userCourse by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserCourse : {}", id);
        userCourseRepository.deleteById(id);
    }
}
