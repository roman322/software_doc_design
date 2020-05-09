package com.mochurad.coursera.web.rest;

import com.mochurad.coursera.domain.UserVideo;
import com.mochurad.coursera.service.UserVideoService;
import com.mochurad.coursera.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mochurad.coursera.domain.UserVideo}.
 */
@RestController
@RequestMapping("/api")
public class UserVideoResource {

    private final Logger log = LoggerFactory.getLogger(UserVideoResource.class);

    private static final String ENTITY_NAME = "userVideo";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserVideoService userVideoService;

    public UserVideoResource(UserVideoService userVideoService) {
        this.userVideoService = userVideoService;
    }

    /**
     * {@code POST  /user-videos} : Create a new userVideo.
     *
     * @param userVideo the userVideo to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userVideo, or with status {@code 400 (Bad Request)} if the userVideo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-videos")
    public ResponseEntity<UserVideo> createUserVideo(@RequestBody UserVideo userVideo) throws URISyntaxException {
        log.debug("REST request to save UserVideo : {}", userVideo);
        if (userVideo.getId() != null) {
            throw new BadRequestAlertException("A new userVideo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserVideo result = userVideoService.save(userVideo);
        return ResponseEntity.created(new URI("/api/user-videos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-videos} : Updates an existing userVideo.
     *
     * @param userVideo the userVideo to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userVideo,
     * or with status {@code 400 (Bad Request)} if the userVideo is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userVideo couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-videos")
    public ResponseEntity<UserVideo> updateUserVideo(@RequestBody UserVideo userVideo) throws URISyntaxException {
        log.debug("REST request to update UserVideo : {}", userVideo);
        if (userVideo.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserVideo result = userVideoService.save(userVideo);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userVideo.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-videos} : get all the userVideos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userVideos in body.
     */
    @GetMapping("/user-videos")
    public List<UserVideo> getAllUserVideos() {
        log.debug("REST request to get all UserVideos");
        return userVideoService.findAll();
    }

    /**
     * {@code GET  /user-videos/:id} : get the "id" userVideo.
     *
     * @param id the id of the userVideo to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userVideo, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-videos/{id}")
    public ResponseEntity<UserVideo> getUserVideo(@PathVariable Long id) {
        log.debug("REST request to get UserVideo : {}", id);
        Optional<UserVideo> userVideo = userVideoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userVideo);
    }

    /**
     * {@code DELETE  /user-videos/:id} : delete the "id" userVideo.
     *
     * @param id the id of the userVideo to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-videos/{id}")
    public ResponseEntity<Void> deleteUserVideo(@PathVariable Long id) {
        log.debug("REST request to delete UserVideo : {}", id);
        userVideoService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
