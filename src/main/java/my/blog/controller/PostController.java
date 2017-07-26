package my.blog.controller;

import my.blog.auth.model.User;
import my.blog.auth.repository.UserRepository;
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
    private final UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Post> list() {
        return this.postRepository.findAll();
    }

    @RequestMapping("test-post")
    private Post testPost(){
        User user = userRepository.findOne(1L);
        Post post = new Post("Hello", "World");
        post.setUser(user);
        postRepository.save(post);
        return post;
    }
}
