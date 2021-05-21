package com.test.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //롬복 어노테이션1 (클래스 내 모든 필드의 GETTER 메소드 자동 생성)
@NoArgsConstructor //롬복 어노테이션1(기본 생성자 자동 추가)
@Entity //jpa 어노테이션(테이블과 링크될 클래스임을 나타낸다)
public class Posts { //실제 DB의 테이블과 매칭될 클래스

    @Id //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 컬럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
