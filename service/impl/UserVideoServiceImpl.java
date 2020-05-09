package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.UserVideoService;
import com.mochurad.coursera.domain.UserVideo;
import com.mochurad.coursera.repository.UserVideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link UserVideo}.
 */
@Service
@Transactional
public class UserVideoServiceImpl implements UserVideoService {

    private final Logger log = LoggerFactory.getLogger(UserVideoServiceImpl.class);

    private final UserVideoRepository userVideoRepository;

    public UserVideoServiceImpl(UserVideoRepository userVideoRepository) {
        this.userVideoRepository = userVideoRepository;
    }

    /**
     * Save a userVideo.
     *
     * @param userVideo the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UserVideo save(UserVideo userVideo) {
        log.debug("Request to save UserVideo : {}", userVideo);
        return userVideoRepository.save(userVideo);
    }

    /**
     * Get all the userVideos.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserVideo> findAll() {
        log.debug("Request to get all UserVideos");
        return userVideoRepository.findAll();
    }

    /**
     * Get one userVideo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserVideo> findOne(Long id) {
        log.debug("Request to get UserVideo : {}", id);
        return userVideoRepository.findById(id);
    }

    /**
     * Delete the userVideo by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserVideo : {}", id);
        userVideoRepository.deleteById(id);
    }
}
