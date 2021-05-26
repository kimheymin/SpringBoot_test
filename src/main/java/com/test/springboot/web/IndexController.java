package com.test.springboot.web;

import com.test.springboot.service.posts.PostService;
import com.test.springboot.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

/*    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave(){
        return "posts-save";
    }*/

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/upste/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostResponseDto dto = postService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
