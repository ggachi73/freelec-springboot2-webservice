package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity//테이블과 매핑,링크될 클래스, 테이븖명과는 카멜표기법을 사용해서 매핑
public class Posts {
    //Entity 클래스로, DB와 매칭될 클래스
    //Setter 메서드를 생성하지 않는다
    @Id//PK 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk 생성규칙, auto_increment설정
    private Long id;

    @Column(length = 500, nullable = false)//컬럼, 선언하지 않아도 필드는 컬럼이다.
    //500같은 옵션을 줄수있다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder//클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
