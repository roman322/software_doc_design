package com.mochurad.coursera.service;

import com.mochurad.coursera.domain.UserVideo;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link UserVideo}.
 */
public interface UserVideoService {

    /**
     * Save a userVideo.
     *
     * @param userVideo the entity to save.
     * @return the persisted entity.
     */
    UserVideo save(UserVideo userVideo);

    /**
     * Get all the userVideos.
     *
     * @return the list of entities.
     */
    List<UserVideo> findAll();

    /**
     * Get the "id" userVideo.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserVideo> findOne(Long id);

    /**
     * Delete the "id" userVideo.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
