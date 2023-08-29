package com.kosa.rest_service.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    // UserService 객체 하나 생성
    @Autowired
    private UserService service;

//     UserService를 인자로 받아서 생성자로 생성하기
//     생성자 생성하는 메서드 없애고
//     @RestController 위에 @AllArgs 어노테이션 붙여도 동일하다.
//    public UserController(UserService service){
//        this.service = service;
//    }
//
//    @GetMapping("/users")
//    public MappingJacksonValue retrieveAllUsers(){
//        List<User> users = service.findAll();
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "password");
//
//        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserInfo", filter);
//
//        MappingJacksonValue mapping = new MappingJacksonValue(users);
//        mapping.setFilters(filterProvider);
//
//        return mapping;
//    }
//
//    @GetMapping("/users/{id}")
//    public MappingJacksonValue retrieveUser(@PathVariable int id){
//        User user = service.findOne(id);
//
//        if(user == null) {
//            throw new UserNotFoundException(String.format("ID[%s] not found", id));
//        }
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
//
//        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserInfo", filter);
//
//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        mapping.setFilters(filterProvider);
//
//        return mapping;
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity createUser(@Valid @RequestBody User user) {
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
//        return ResponseEntity.created(location).build();
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
