package com.sparta.memo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class CommentRequestDto {
    private final String comment;
    private final Long memoId;
}
