package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.InstitutionService;
import com.mochurad.coursera.domain.Institution;
import com.mochurad.coursera.repository.InstitutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Institution}.
 */
@Service
@Transactional
public class InstitutionServiceImpl implements InstitutionService {

    private final Logger log = LoggerFactory.getLogger(InstitutionServiceImpl.class);

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    /**
     * Save a institution.
     *
     * @param institution the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Institution save(Institution institution) {
        log.debug("Request to save Institution : {}", institution);
        return institutionRepository.save(institution);
    }

    /**
     * Get all the institutions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Institution> findAll() {
        log.debug("Request to get all Institutions");
        return institutionRepository.findAll();
    }

    /**
     * Get one institution by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Institution> findOne(Long id) {
        log.debug("Request to get Institution : {}", id);
        return institutionRepository.findById(id);
    }

    /**
     * Delete the institution by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Institution : {}", id);
        institutionRepository.deleteById(id);
    }
}
