package my.blog.controller;

import my.blog.model.Post;
import my.blog.repository.PostRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Post> list() {
        return this.postRepository.findAll();
    }
}
