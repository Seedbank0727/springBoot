package com.kosa.rest_service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository; //User DAO

    @Autowired
    private PostRepository postRepository; //Post DAO

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPosts(@PathVariable int id,@RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        post.setUser(user.get()); //post안에 User가 들어감
        Post savePost = postRepository.save(post); //savePost는 미리 생성된 ID번호를 미리 지니고 있음(시퀀스 미리 실행)

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{postID}")
                .buildAndExpand(savePost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping("/users/{id}/posts")
    /**id에 해당하는 유저가 쓴 글의 목록*/
    public List<Post> retrieveAllPostByUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user.get().getPosts();
    }

//    public UserJpaController(UserService service){
//        this.service = service;
//    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<Optional<User>> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id); // 데이터가 없을 수 있기 때문에 optional 객체를 선언

        if(!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return EntityModel.of(user,
                linkTo(methodOn(UserJpaController.class).retrieveAllUsers()).withRel("all-users"));
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        // 클라이언트가 방금 입력한 정보를 확인하고 싶을 수 있으므로
        // Header에 URI 정보를 준다.

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // 이렇게 리턴하면 201 OK가 된다.
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

}
