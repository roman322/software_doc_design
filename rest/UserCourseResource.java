package com.mochurad.coursera.web.rest;

import com.mochurad.coursera.domain.UserCourse;
import com.mochurad.coursera.service.UserCourseService;
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
 * REST controller for managing {@link com.mochurad.coursera.domain.UserCourse}.
 */
@RestController
@RequestMapping("/api")
public class UserCourseResource {

    private final Logger log = LoggerFactory.getLogger(UserCourseResource.class);

    private static final String ENTITY_NAME = "userCourse";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserCourseService userCourseService;

    public UserCourseResource(UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    /**
     * {@code POST  /user-courses} : Create a new userCourse.
     *
     * @param userCourse the userCourse to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userCourse, or with status {@code 400 (Bad Request)} if the userCourse has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-courses")
    public ResponseEntity<UserCourse> createUserCourse(@RequestBody UserCourse userCourse) throws URISyntaxException {
        log.debug("REST request to save UserCourse : {}", userCourse);
        if (userCourse.getId() != null) {
            throw new BadRequestAlertException("A new userCourse cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserCourse result = userCourseService.save(userCourse);
        return ResponseEntity.created(new URI("/api/user-courses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-courses} : Updates an existing userCourse.
     *
     * @param userCourse the userCourse to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userCourse,
     * or with status {@code 400 (Bad Request)} if the userCourse is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userCourse couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-courses")
    public ResponseEntity<UserCourse> updateUserCourse(@RequestBody UserCourse userCourse) throws URISyntaxException {
        log.debug("REST request to update UserCourse : {}", userCourse);
        if (userCourse.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserCourse result = userCourseService.save(userCourse);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userCourse.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-courses} : get all the userCourses.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userCourses in body.
     */
    @GetMapping("/user-courses")
    public List<UserCourse> getAllUserCourses() {
        log.debug("REST request to get all UserCourses");
        return userCourseService.findAll();
    }

    /**
     * {@code GET  /user-courses/:id} : get the "id" userCourse.
     *
     * @param id the id of the userCourse to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userCourse, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-courses/{id}")
    public ResponseEntity<UserCourse> getUserCourse(@PathVariable Long id) {
        log.debug("REST request to get UserCourse : {}", id);
        Optional<UserCourse> userCourse = userCourseService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userCourse);
    }

    /**
     * {@code DELETE  /user-courses/:id} : delete the "id" userCourse.
     *
     * @param id the id of the userCourse to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-courses/{id}")
    public ResponseEntity<Void> deleteUserCourse(@PathVariable Long id) {
        log.debug("REST request to delete UserCourse : {}", id);
        userCourseService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
