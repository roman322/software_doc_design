package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.UserInterestedProgramService;
import com.mochurad.coursera.domain.UserInterestedProgram;
import com.mochurad.coursera.repository.UserInterestedProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link UserInterestedProgram}.
 */
@Service
@Transactional
public class UserInterestedProgramServiceImpl implements UserInterestedProgramService {

    private final Logger log = LoggerFactory.getLogger(UserInterestedProgramServiceImpl.class);

    private final UserInterestedProgramRepository userInterestedProgramRepository;

    public UserInterestedProgramServiceImpl(UserInterestedProgramRepository userInterestedProgramRepository) {
        this.userInterestedProgramRepository = userInterestedProgramRepository;
    }

    /**
     * Save a userInterestedProgram.
     *
     * @param userInterestedProgram the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UserInterestedProgram save(UserInterestedProgram userInterestedProgram) {
        log.debug("Request to save UserInterestedProgram : {}", userInterestedProgram);
        return userInterestedProgramRepository.save(userInterestedProgram);
    }

    /**
     * Get all the userInterestedPrograms.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserInterestedProgram> findAll() {
        log.debug("Request to get all UserInterestedPrograms");
        return userInterestedProgramRepository.findAll();
    }

    /**
     * Get one userInterestedProgram by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserInterestedProgram> findOne(Long id) {
        log.debug("Request to get UserInterestedProgram : {}", id);
        return userInterestedProgramRepository.findById(id);
    }

    /**
     * Delete the userInterestedProgram by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete UserInterestedProgram : {}", id);
        userInterestedProgramRepository.deleteById(id);
    }
}
