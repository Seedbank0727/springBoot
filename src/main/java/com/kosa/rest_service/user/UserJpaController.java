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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {
    @Autowired
    private UserRepository userRepository;
//    public UserJpaController(UserService service){
//        this.service = service;
//    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveUser(@PathVariable int id){
//        User user = service.findOne(id);
//
//        if(user == null) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        return EntityModel.of(user,
//                linkTo(methodOn(UserJpaController.class).retrieveAllUsers()).withRel("all-users"));
//    }
//
//    @PostMapping("/users")
//    public User createUser(@Valid @RequestBody User user) {
//        User savedUser = service.save(user);
//
//        // 클라이언트가 방금 입력한 정보를 확인하고 싶을 수 있으므로
//        // Header에 URI 정보를 준다.
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        // 이렇게 리턴하면 201 OK가 된다.
//        return user;
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id) {
//        User user = service.deleteById(id);
//
//        if(user == null) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//    }

}
