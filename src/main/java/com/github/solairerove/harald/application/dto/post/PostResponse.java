package com.github.solairerove.harald.application.dto.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.github.solairerove.harald.application.dto.comment.CommentResponse;
import com.github.solairerove.harald.application.dto.comment.CommentsResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonTypeName(value = "post")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class PostResponse implements Serializable {

    private static final long serialVersionUID = 8221818444202026540L;

    @JsonProperty
    private Long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String author;

    @JsonProperty
    private String date;

    @JsonProperty
    private String content;

    @JsonProperty
    @JsonUnwrapped
    private CommentsResponse comments;
}
