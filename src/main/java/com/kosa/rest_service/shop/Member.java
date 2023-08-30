package com.kosa.rest_service.shop;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    public static Member createMember(String name, String email){
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);

        return member;
    }
}
