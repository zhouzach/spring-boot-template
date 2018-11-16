package org.rabbit.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

/**
 * 数据库Model统一公共字段
 * id:  自增 id
 * createdTime: 建立时间 ， 以系统时间区域为准
 * updatedTime: 更新时间
 * created by pengmingguo on 2/8/18
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = -6387969931129402263L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Integer id;

//    @Column(name = "gmt_create")
//    private Date createdTime;
//
//    @Column(name = "gmt_modified")
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
        if (!(o instanceof BaseModel)) {
            return false;
        }
        BaseModel baseModel = (BaseModel) o;
        return Objects.equals(id, baseModel.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
