package com.mochurad.coursera.service.impl;

import com.mochurad.coursera.service.VideoTranscriptLanguageService;
import com.mochurad.coursera.domain.VideoTranscriptLanguage;
import com.mochurad.coursera.repository.VideoTranscriptLanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link VideoTranscriptLanguage}.
 */
@Service
@Transactional
public class VideoTranscriptLanguageServiceImpl implements VideoTranscriptLanguageService {

    private final Logger log = LoggerFactory.getLogger(VideoTranscriptLanguageServiceImpl.class);

    private final VideoTranscriptLanguageRepository videoTranscriptLanguageRepository;

    public VideoTranscriptLanguageServiceImpl(VideoTranscriptLanguageRepository videoTranscriptLanguageRepository) {
        this.videoTranscriptLanguageRepository = videoTranscriptLanguageRepository;
    }

    /**
     * Save a videoTranscriptLanguage.
     *
     * @param videoTranscriptLanguage the entity to save.
     * @return the persisted entity.
     */
    @Override
    public VideoTranscriptLanguage save(VideoTranscriptLanguage videoTranscriptLanguage) {
        log.debug("Request to save VideoTranscriptLanguage : {}", videoTranscriptLanguage);
        return videoTranscriptLanguageRepository.save(videoTranscriptLanguage);
    }

    /**
     * Get all the videoTranscriptLanguages.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<VideoTranscriptLanguage> findAll() {
        log.debug("Request to get all VideoTranscriptLanguages");
        return videoTranscriptLanguageRepository.findAll();
    }

    /**
     * Get one videoTranscriptLanguage by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<VideoTranscriptLanguage> findOne(Long id) {
        log.debug("Request to get VideoTranscriptLanguage : {}", id);
        return videoTranscriptLanguageRepository.findById(id);
    }

    /**
     * Delete the videoTranscriptLanguage by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete VideoTranscriptLanguage : {}", id);
        videoTranscriptLanguageRepository.deleteById(id);
    }
}
