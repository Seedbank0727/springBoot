package com.kosa.rest_service.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})
//@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min = 2, message = "Name을 2글자 이상 입력하세요.")
    private String name;

    @Past // 과거의 날짜를 입력하지 못하도록 하는 어노테이션
    private Date joinDate;

//    @JsonIgnore
    private String password;
//    @JsonIgnore
    private String ssn;
}
