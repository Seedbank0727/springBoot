package com.kosa.rest_service.user;

import org.springframework.data.jpa.repository.JpaRepository;

//DAO의 역할을 함
public interface UserRepository extends JpaRepository<User,Integer> // JpaRepository<객체,기본키 타입>
{

}
