package com.mochurad.coursera.service;

import com.mochurad.coursera.domain.UserCourse;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link UserCourse}.
 */
public interface UserCourseService {

    /**
     * Save a userCourse.
     *
     * @param userCourse the entity to save.
     * @return the persisted entity.
     */
    UserCourse save(UserCourse userCourse);

    /**
     * Get all the userCourses.
     *
     * @return the list of entities.
     */
    List<UserCourse> findAll();

    /**
     * Get the "id" userCourse.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserCourse> findOne(Long id);

    /**
     * Delete the "id" userCourse.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
