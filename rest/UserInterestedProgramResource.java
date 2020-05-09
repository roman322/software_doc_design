package com.mochurad.coursera.web.rest;

import com.mochurad.coursera.domain.UserInterestedProgram;
import com.mochurad.coursera.service.UserInterestedProgramService;
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
 * REST controller for managing {@link com.mochurad.coursera.domain.UserInterestedProgram}.
 */
@RestController
@RequestMapping("/api")
public class UserInterestedProgramResource {

    private final Logger log = LoggerFactory.getLogger(UserInterestedProgramResource.class);

    private static final String ENTITY_NAME = "userInterestedProgram";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserInterestedProgramService userInterestedProgramService;

    public UserInterestedProgramResource(UserInterestedProgramService userInterestedProgramService) {
        this.userInterestedProgramService = userInterestedProgramService;
    }

    /**
     * {@code POST  /user-interested-programs} : Create a new userInterestedProgram.
     *
     * @param userInterestedProgram the userInterestedProgram to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userInterestedProgram, or with status {@code 400 (Bad Request)} if the userInterestedProgram has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-interested-programs")
    public ResponseEntity<UserInterestedProgram> createUserInterestedProgram(@RequestBody UserInterestedProgram userInterestedProgram) throws URISyntaxException {
        log.debug("REST request to save UserInterestedProgram : {}", userInterestedProgram);
        if (userInterestedProgram.getId() != null) {
            throw new BadRequestAlertException("A new userInterestedProgram cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserInterestedProgram result = userInterestedProgramService.save(userInterestedProgram);
        return ResponseEntity.created(new URI("/api/user-interested-programs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-interested-programs} : Updates an existing userInterestedProgram.
     *
     * @param userInterestedProgram the userInterestedProgram to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userInterestedProgram,
     * or with status {@code 400 (Bad Request)} if the userInterestedProgram is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userInterestedProgram couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-interested-programs")
    public ResponseEntity<UserInterestedProgram> updateUserInterestedProgram(@RequestBody UserInterestedProgram userInterestedProgram) throws URISyntaxException {
        log.debug("REST request to update UserInterestedProgram : {}", userInterestedProgram);
        if (userInterestedProgram.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserInterestedProgram result = userInterestedProgramService.save(userInterestedProgram);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userInterestedProgram.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-interested-programs} : get all the userInterestedPrograms.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userInterestedPrograms in body.
     */
    @GetMapping("/user-interested-programs")
    public List<UserInterestedProgram> getAllUserInterestedPrograms() {
        log.debug("REST request to get all UserInterestedPrograms");
        return userInterestedProgramService.findAll();
    }

    /**
     * {@code GET  /user-interested-programs/:id} : get the "id" userInterestedProgram.
     *
     * @param id the id of the userInterestedProgram to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userInterestedProgram, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-interested-programs/{id}")
    public ResponseEntity<UserInterestedProgram> getUserInterestedProgram(@PathVariable Long id) {
        log.debug("REST request to get UserInterestedProgram : {}", id);
        Optional<UserInterestedProgram> userInterestedProgram = userInterestedProgramService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userInterestedProgram);
    }

    /**
     * {@code DELETE  /user-interested-programs/:id} : delete the "id" userInterestedProgram.
     *
     * @param id the id of the userInterestedProgram to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-interested-programs/{id}")
    public ResponseEntity<Void> deleteUserInterestedProgram(@PathVariable Long id) {
        log.debug("REST request to delete UserInterestedProgram : {}", id);
        userInterestedProgramService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
