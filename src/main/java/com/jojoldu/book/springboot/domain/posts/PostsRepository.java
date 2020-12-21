package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//MyBatis의 DAO와 같은 DB Layer 접근자. JPA에선 Repository라함
//JpaRepository<E class, PK 타입>을 상속하면 CRUD 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
