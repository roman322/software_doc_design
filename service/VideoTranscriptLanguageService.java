package com.mochurad.coursera.service;

import com.mochurad.coursera.domain.VideoTranscriptLanguage;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link VideoTranscriptLanguage}.
 */
public interface VideoTranscriptLanguageService {

    /**
     * Save a videoTranscriptLanguage.
     *
     * @param videoTranscriptLanguage the entity to save.
     * @return the persisted entity.
     */
    VideoTranscriptLanguage save(VideoTranscriptLanguage videoTranscriptLanguage);

    /**
     * Get all the videoTranscriptLanguages.
     *
     * @return the list of entities.
     */
    List<VideoTranscriptLanguage> findAll();

    /**
     * Get the "id" videoTranscriptLanguage.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VideoTranscriptLanguage> findOne(Long id);

    /**
     * Delete the "id" videoTranscriptLanguage.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
