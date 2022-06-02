package com.sparta.memo.service;

import com.sparta.memo.domain.Comment;
import com.sparta.memo.dto.CommentRequestDto;
import com.sparta.memo.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto requestDto){

        Comment comment = commentRepository.findByIdAndMemoId(id,requestDto.getMemoId());
        if(comment == null){
            throw new IllegalArgumentException("없는 메모입니다.");
        }

        comment.update(requestDto);
        return id;
    }

    @Transactional
    public Long delete(Long id, CommentRequestDto requestDto){

        Comment comment = commentRepository.findByIdAndMemoId(id, requestDto.getMemoId());
        if(comment == null){
            throw new IllegalArgumentException("없는메모입니다.");
        }else{commentRepository.deleteById(id);}

        return id;
    }

}
