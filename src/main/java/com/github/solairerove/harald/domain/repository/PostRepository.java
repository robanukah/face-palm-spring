package com.github.solairerove.harald.domain.repository;

import com.github.solairerove.harald.domain.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM post WHERE id = ?1", nativeQuery = true)
    Optional<Post> findOneById(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE post " +
            "SET author = COALESCE(?2, author) " +
            "WHERE id = ?1 " +
            "AND (?2 IS NOT NULL AND ?2 IS DISTINCT FROM author)", nativeQuery = true)
    void updateOneById(Long id, String author);
}
