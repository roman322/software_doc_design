package com.mochurad.coursera.web.rest;

import com.mochurad.coursera.domain.CourseraUser;
import com.mochurad.coursera.service.CourseraUserService;
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
 * REST controller for managing {@link com.mochurad.coursera.domain.CourseraUser}.
 */
@RestController
@RequestMapping("/api")
public class CourseraUserResource {

    private final Logger log = LoggerFactory.getLogger(CourseraUserResource.class);

    private static final String ENTITY_NAME = "courseraUser";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CourseraUserService courseraUserService;

    public CourseraUserResource(CourseraUserService courseraUserService) {
        this.courseraUserService = courseraUserService;
    }

    /**
     * {@code POST  /coursera-users} : Create a new courseraUser.
     *
     * @param courseraUser the courseraUser to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new courseraUser, or with status {@code 400 (Bad Request)} if the courseraUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/coursera-users")
    public ResponseEntity<CourseraUser> createCourseraUser(@Valid @RequestBody CourseraUser courseraUser) throws URISyntaxException {
        log.debug("REST request to save CourseraUser : {}", courseraUser);
        if (courseraUser.getId() != null) {
            throw new BadRequestAlertException("A new courseraUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CourseraUser result = courseraUserService.save(courseraUser);
        return ResponseEntity.created(new URI("/api/coursera-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /coursera-users} : Updates an existing courseraUser.
     *
     * @param courseraUser the courseraUser to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated courseraUser,
     * or with status {@code 400 (Bad Request)} if the courseraUser is not valid,
     * or with status {@code 500 (Internal Server Error)} if the courseraUser couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/coursera-users")
    public ResponseEntity<CourseraUser> updateCourseraUser(@Valid @RequestBody CourseraUser courseraUser) throws URISyntaxException {
        log.debug("REST request to update CourseraUser : {}", courseraUser);
        if (courseraUser.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CourseraUser result = courseraUserService.save(courseraUser);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, courseraUser.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /coursera-users} : get all the courseraUsers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of courseraUsers in body.
     */
    @GetMapping("/coursera-users")
    public List<CourseraUser> getAllCourseraUsers() {
        log.debug("REST request to get all CourseraUsers");
        return courseraUserService.findAll();
    }

    /**
     * {@code GET  /coursera-users/:id} : get the "id" courseraUser.
     *
     * @param id the id of the courseraUser to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the courseraUser, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/coursera-users/{id}")
    public ResponseEntity<CourseraUser> getCourseraUser(@PathVariable Long id) {
        log.debug("REST request to get CourseraUser : {}", id);
        Optional<CourseraUser> courseraUser = courseraUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(courseraUser);
    }

    /**
     * {@code DELETE  /coursera-users/:id} : delete the "id" courseraUser.
     *
     * @param id the id of the courseraUser to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/coursera-users/{id}")
    public ResponseEntity<Void> deleteCourseraUser(@PathVariable Long id) {
        log.debug("REST request to delete CourseraUser : {}", id);
        courseraUserService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
