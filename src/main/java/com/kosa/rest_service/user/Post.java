package com.kosa.rest_service.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//User:Post ==> 1(Main): N(Sub) => 부모 자식간의 관계
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    /**연관 관계를 정의 하는 내용임 */
    @ManyToOne(fetch = FetchType.LAZY) // 다:1 의 관계, Post에서 데이터를 필요로 할 때
    @JsonIgnore
    private User user; //연관 관계임

}
