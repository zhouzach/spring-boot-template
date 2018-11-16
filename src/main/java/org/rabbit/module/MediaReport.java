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
  name = "pe_result_media",
  indexes = {
    @Index(name = "time_index", columnList = "time", unique = false),
          @Index(name = "media_index", columnList = "mediaId", unique = false),
          @Index(name = "act_index", columnList = "activityId", unique = false),
          @Index(name = "ad_index", columnList = "advertisementId", unique = false),
          @Index(name = "gift_index", columnList = "giftId", unique = false),
          @Index(name = "reg_index", columnList = "regionId", unique = false),
          @Index(name = "format_index", columnList = "formatId", unique = false),
          @Index(name = "prod_index", columnList = "productId", unique = false),
  }
)
public class MediaReport extends BaseModel {

  private String time;
  private String userId;
  private String mediaId;
  private String mediaName;
  private String advertisementId;
  private String activityId;
  private String activityName;
  private String giftId;
  private String giftName;
  private String regionId;
  private String formatId;
  private String formatName;
  private String productId;

  private Long register;
  private Long sale;
  private Double cleaningRate;
  private Long valid;
  private Double validRate;
  private Long centerVisits;
  private Double visitingRate;
  private Long contract;
  private Double contractRate;



}
