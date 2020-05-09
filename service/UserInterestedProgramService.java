package com.mochurad.coursera.service;

import com.mochurad.coursera.domain.UserInterestedProgram;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link UserInterestedProgram}.
 */
public interface UserInterestedProgramService {

    /**
     * Save a userInterestedProgram.
     *
     * @param userInterestedProgram the entity to save.
     * @return the persisted entity.
     */
    UserInterestedProgram save(UserInterestedProgram userInterestedProgram);

    /**
     * Get all the userInterestedPrograms.
     *
     * @return the list of entities.
     */
    List<UserInterestedProgram> findAll();

    /**
     * Get the "id" userInterestedProgram.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserInterestedProgram> findOne(Long id);

    /**
     * Delete the "id" userInterestedProgram.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
