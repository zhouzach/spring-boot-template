package org.rabbit.module;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/** created by pengmingguo on 2/9/18 */
@Getter
@Setter
public class Msg<T> implements Serializable {
  private static final long serialVersionUID = -2417860503542275729L;

  public Msg(Integer status) {
    this.status = status;
  }

  public Msg() {}

  public static Integer OK = 200;

  public static Integer ERR = 400;

  private Integer status;

//  private String action;

  private T data;

//  private String reason;

  public static <E> Msg<E> ok() {
    return new Msg<>(OK);
  }

  public static <E> Msg<E> ok(E data) {
    Msg<E> msg = new Msg<>(OK);
    msg.setData(data);
    return msg;
  }

  public static <E> Msg<E> err() {
    return new Msg<>(ERR);
  }

  @Getter
  @Setter
  public static class Reason<E> implements Serializable {
    private E reason;
  }

  public static <E> Msg<Reason<E>> err(E data) {
    Msg<Reason<E>> msg = new Msg<>(ERR);
    Reason<E> eReason = new Reason<>();
    eReason.reason = data;
    msg.setData(eReason);
    return msg;
  }
//  public static <E,B> Msg<E> err(B reason) {
//    Msg<E> mes = new Msg<>(ERR);
//    mes.setReason(reason.toString());
//    return mes;
//  }

  public Msg<T> status(Integer code) {
    this.setStatus(code);
    return this;
  }
}
