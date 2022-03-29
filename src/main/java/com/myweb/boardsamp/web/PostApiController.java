package com.myweb.boardsamp.web;


import com.myweb.boardsamp.service.posts.PostsService;
import com.myweb.boardsamp.web.dto.PostsResponseDto;
import com.myweb.boardsamp.web.dto.PostsSaveRequestDto;
import com.myweb.boardsamp.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable("id") Long id){
        System.out.println("Delete api call!!");
        postsService.delete(id);

        return id;
    }
}
