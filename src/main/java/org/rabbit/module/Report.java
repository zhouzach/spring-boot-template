package org.rabbit.module;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(
        name = "t_report",
        indexes = {
                @Index(name = "time_index", columnList = "time", unique = false),
                @Index(name = "user_index", columnList = "userId", unique = false),
        }
)
public class Report extends BaseRecord {

    private String time;
    private String userId;

}
