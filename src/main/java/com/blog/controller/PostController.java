package com.blog.controller;

import com.blog.dto.PostDto;
import com.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import java.util.List;

@Controller()
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/admin/posts")
    public String posts(Model model){
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }


   @GetMapping("/admin/posts/newpost")
   public String newPostForm(Model model){
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "admin/create_post";
   }





   @PostMapping("/admin/posts")
   public String createPost(@Valid @ModelAttribute("post") PostDto postDto,
                            BindingResult bindResult, Model model){

        if(bindResult.hasErrors()){
            model.addAttribute("post", postDto);
            return "admin/create_post";
        }
        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
   }

   private static String getUrl(String postTitle){
        String title = postTitle.trim().toLowerCase();
        String url = title.replace("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
   }

    @GetMapping("/admin/posts/{postId}/edit")
    public String editPostForm(@PathVariable("postId") Long postId,
                               Model model){

        PostDto postDto = postService.findPostById(postId);
        model.addAttribute("post", postDto);
        return "admin/edit_post";
    }

    @PostMapping("/admin/posts/{postId}")
    public String updatePost(@PathVariable("postId") Long postId, @Valid @ModelAttribute("post") PostDto postDto,
     Model model, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        model.addAttribute("post", postDto);
        return "admin/create_post";
    }
        postDto.setId(postId);
        postService.updatePost(postDto);
        return "redirect:/admin/posts";
    }

@GetMapping("/admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
        return "redirect:/admin/posts";
    }



    @GetMapping("/admin/posts/{postId}/delete")
    public String viewPost(@PathVariable("postId") String postUrl, Model model){
        PostDto postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);
        return "admin/view_post";
    }

}
