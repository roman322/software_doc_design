package com.mochurad.coursera.service;

import com.mochurad.coursera.domain.CourseraUser;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link CourseraUser}.
 */
public interface CourseraUserService {

    /**
     * Save a courseraUser.
     *
     * @param courseraUser the entity to save.
     * @return the persisted entity.
     */
    CourseraUser save(CourseraUser courseraUser);

    /**
     * Get all the courseraUsers.
     *
     * @return the list of entities.
     */
    List<CourseraUser> findAll();

    /**
     * Get the "id" courseraUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CourseraUser> findOne(Long id);

    /**
     * Delete the "id" courseraUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
