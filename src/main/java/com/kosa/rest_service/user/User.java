package com.kosa.rest_service.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})
//@JsonFilter("UserInfo")
@Entity
@Table(name = "user2")

public class User { //JPA 테이블임
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

    /**연관 관계를 정의 하는 내용임 */
    @OneToMany(mappedBy = "user") // 1:다 의 관계 , mappedBy = 다에서 정해준 이름
    private List<Post> posts;

    public User(int id,String name, Date joinDate, String password, String ssn){
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }
}
