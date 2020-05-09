package com.mochurad.coursera.web.rest;

import com.mochurad.coursera.domain.VideoTranscriptLanguage;
import com.mochurad.coursera.service.VideoTranscriptLanguageService;
import com.mochurad.coursera.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mochurad.coursera.domain.VideoTranscriptLanguage}.
 */
@RestController
@RequestMapping("/api")
public class VideoTranscriptLanguageResource {

    private final Logger log = LoggerFactory.getLogger(VideoTranscriptLanguageResource.class);

    private static final String ENTITY_NAME = "videoTranscriptLanguage";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VideoTranscriptLanguageService videoTranscriptLanguageService;

    public VideoTranscriptLanguageResource(VideoTranscriptLanguageService videoTranscriptLanguageService) {
        this.videoTranscriptLanguageService = videoTranscriptLanguageService;
    }

    /**
     * {@code POST  /video-transcript-languages} : Create a new videoTranscriptLanguage.
     *
     * @param videoTranscriptLanguage the videoTranscriptLanguage to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new videoTranscriptLanguage, or with status {@code 400 (Bad Request)} if the videoTranscriptLanguage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/video-transcript-languages")
    public ResponseEntity<VideoTranscriptLanguage> createVideoTranscriptLanguage(@Valid @RequestBody VideoTranscriptLanguage videoTranscriptLanguage) throws URISyntaxException {
        log.debug("REST request to save VideoTranscriptLanguage : {}", videoTranscriptLanguage);
        if (videoTranscriptLanguage.getId() != null) {
            throw new BadRequestAlertException("A new videoTranscriptLanguage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VideoTranscriptLanguage result = videoTranscriptLanguageService.save(videoTranscriptLanguage);
        return ResponseEntity.created(new URI("/api/video-transcript-languages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /video-transcript-languages} : Updates an existing videoTranscriptLanguage.
     *
     * @param videoTranscriptLanguage the videoTranscriptLanguage to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated videoTranscriptLanguage,
     * or with status {@code 400 (Bad Request)} if the videoTranscriptLanguage is not valid,
     * or with status {@code 500 (Internal Server Error)} if the videoTranscriptLanguage couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/video-transcript-languages")
    public ResponseEntity<VideoTranscriptLanguage> updateVideoTranscriptLanguage(@Valid @RequestBody VideoTranscriptLanguage videoTranscriptLanguage) throws URISyntaxException {
        log.debug("REST request to update VideoTranscriptLanguage : {}", videoTranscriptLanguage);
        if (videoTranscriptLanguage.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VideoTranscriptLanguage result = videoTranscriptLanguageService.save(videoTranscriptLanguage);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, videoTranscriptLanguage.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /video-transcript-languages} : get all the videoTranscriptLanguages.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of videoTranscriptLanguages in body.
     */
    @GetMapping("/video-transcript-languages")
    public List<VideoTranscriptLanguage> getAllVideoTranscriptLanguages() {
        log.debug("REST request to get all VideoTranscriptLanguages");
        return videoTranscriptLanguageService.findAll();
    }

    /**
     * {@code GET  /video-transcript-languages/:id} : get the "id" videoTranscriptLanguage.
     *
     * @param id the id of the videoTranscriptLanguage to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the videoTranscriptLanguage, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/video-transcript-languages/{id}")
    public ResponseEntity<VideoTranscriptLanguage> getVideoTranscriptLanguage(@PathVariable Long id) {
        log.debug("REST request to get VideoTranscriptLanguage : {}", id);
        Optional<VideoTranscriptLanguage> videoTranscriptLanguage = videoTranscriptLanguageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(videoTranscriptLanguage);
    }

    /**
     * {@code DELETE  /video-transcript-languages/:id} : delete the "id" videoTranscriptLanguage.
     *
     * @param id the id of the videoTranscriptLanguage to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/video-transcript-languages/{id}")
    public ResponseEntity<Void> deleteVideoTranscriptLanguage(@PathVariable Long id) {
        log.debug("REST request to delete VideoTranscriptLanguage : {}", id);
        videoTranscriptLanguageService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
