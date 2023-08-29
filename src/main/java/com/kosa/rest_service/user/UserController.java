package com.kosa.rest_service.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {
    // UserService 객체 하나 생성
    @Autowired
    private UserService service;

    // UserService를 인자로 받아서 생성자로 생성하기
    // 생성자 생성하는 메서드 없애고
    // @RestController 위에 @AllArgs 어노테이션 붙여도 동일하다.
//    public UserController(UserService service){
//        this.service = service;
//    }

    @GetMapping("/users")
    public ResponseEntity retrieveAllUsers(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);

        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("all-users"));
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        // 클라이언트가 방금 입력한 정보를 확인하고 싶을 수 있으므로
        // Header에 URI 정보를 준다.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // 이렇게 리턴하면 201 OK가 된다.
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if(user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

}
