package com.kosa.rest_service.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})
//@JsonFilter("UserInfo")
@Entity
@Table(name = "user2")

public class User {
    @Id
    @GeneratedValue// 1씩 증가하는 옵션
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
