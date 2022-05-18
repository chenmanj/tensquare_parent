package com.tensquare.recruit.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 职位
 */
@Setter
@Getter
@Entity
@Table(name = "tb_recruit")
public class TbRecruit implements Serializable {

  @Id
  private String id;
  private String jobname;
  private String salary;
  private String condition;
  private String education;
  private String type;
  private String address;
  private String eid;
  private Date createtime;
  private String state;
  private String url;
  private String label;
  private String content1;
  private String content2;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    TbRecruit tbRecret = (TbRecruit) o;
    return id != null && Objects.equals(id, tbRecret.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

}
