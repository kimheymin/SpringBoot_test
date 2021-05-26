package com.test.springboot.service.posts;

import com.test.springboot.domain.posts.PostRepository;
import com.test.springboot.domain.posts.Posts;
import com.test.springboot.web.dto.PostListResponseDto;
import com.test.springboot.web.dto.PostResponseDto;
import com.test.springboot.web.dto.PostSaveRequestDto;
import com.test.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostResponseDto findById (Long id){
        Posts entity = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없음, id="+id));
        postRepository.delete(posts);
    }
}
