package org.rabbit.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseRecord implements Serializable {

    private static final long serialVersionUID = -7497969931129502264L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

//    @Column(name = "create_time")
//    private Date createdTime;
//
//    @Column(name = "modified_time")
//    private Date updatedTime;
//
//    @PreUpdate
//    void updateTime() {
//        this.updatedTime = new Date();
//    }
//
//    @PrePersist
//    void createTime() {
//        this.createdTime = new Date();
//        this.updatedTime = createdTime;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseRecord)) {
            return false;
        }
        BaseRecord baseRecord = (BaseRecord) o;
        return Objects.equals(id, baseRecord.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
