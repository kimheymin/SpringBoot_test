package com.test.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //jpa entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 컬럼을 인식하도록 해줌
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 auditing 기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate //엔티티가 생성되어 저장될 떄 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회된 엔티티 값 변경 시 시간이 자동 저장
    private LocalDateTime modifiedDate;

}
