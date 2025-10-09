package io.github.arivanamin.lms.backend.base.core.pagination;

import lombok.Value;

import java.util.List;

@Value
public class PaginatedResponse<T> {

    PageData pageData;
    List<T> content;

    public static <T> PaginatedResponse<T> of (PageData pageData, List<T> content) {
        return new PaginatedResponse<>(pageData, content);
    }
}
