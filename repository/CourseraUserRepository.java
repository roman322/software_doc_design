package com.mochurad.coursera.repository;

import com.mochurad.coursera.domain.CourseraUser;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the CourseraUser entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseraUserRepository extends JpaRepository<CourseraUser, Long> {
}
