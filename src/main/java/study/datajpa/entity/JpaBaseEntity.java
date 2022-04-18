package study.datajpa.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        // 등록일과 수정일을 똑같이 맞춰놓는다.
        createdDate = now;
        updatedDate = now;
    }

    // Updatedate가 있으면 갱신
    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
