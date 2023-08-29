package com.kosa.rest_service.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!!!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Douzone!!!");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean2(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello WorldBean, %s", name));
    }

    @GetMapping("/hello-world-international")
    public String helloWorldInternational(@RequestHeader(name="Accept-Language",required=false)
                                          Locale locale){
        // 1. 요청 Header에서 Accept-Language라는 이름을 키값으로 사용하여 정보를 받아와서
        //     어떤 언어로 요청했는지 먼저 체크한다.
        // 2. messageSource 객체의 getMessage 메서드를 이용해서 messages.properties에 있는
        //     greeting.message 이름을 가진 메시지의 값을 가져온다.
        // locale 정보에 따라서 greeting.message의 각각 다른 값이 전달되어 출력된다.
        return messageSource.getMessage("greeting.message", null, locale);
    }
}
