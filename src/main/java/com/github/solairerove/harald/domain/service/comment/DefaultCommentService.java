package com.github.solairerove.harald.domain.service.comment;

import com.github.solairerove.harald.domain.model.Comment;
import com.github.solairerove.harald.domain.model.exception.ResourceNotFoundException;
import com.github.solairerove.harald.domain.repository.CommentRepository;
import com.github.solairerove.harald.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultCommentService implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository repository;

    @Override
    public Comment create(final Long id, final Comment comment) {
        log.info("Create comment: {} in post: {}", comment, id);

        comment.setPostId(id);

        return repository.save(comment);
    }

    @Override
    public Comment fetchById(final Long postId, final Long commentId) {
        log.info("Fetch comment: {} from post: {}", commentId, postId);

        return Optional.ofNullable(repository.findOneById(postId, commentId))
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id: " + commentId
                        + " doesn't exist in post: " + postId));
    }

    @Override
    public List<Comment> fetchAllFromPost(final Long postId) {
        log.info("Fetch all comments from post: {}", postId);

        return repository.findAllByPostId(postId);
    }

    @Override
    public Comment update(final Long postId, final Long commentId, final Comment comment) {
        log.info("Update comment: {} by id: {} from post: {}", comment, commentId, postId);

        return null;
    }
}
