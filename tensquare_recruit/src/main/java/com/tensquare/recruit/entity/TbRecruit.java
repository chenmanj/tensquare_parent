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

  /**
   * 招聘职位
   */
  private String jobname;

  /**
   * 薪资范围
   */
  private String salary;

  /**
   * 经验要求
   */
  private String condition;

  /**
   * 学历要求
   */
  private String education;

  /**
   * 任职方式
   */
  private String type;

  /**
   * 办公地址
   */
  private String address;

  /**
   * 企业ID
   */
  private String eid;

  /**
   * 发布日期
   */
  private Date createtime;

  /**
   * 状态（0:关闭 1:开启 2:推荐）
   */
  private String state;

  /**
   * 原网址
   */
  private String url;

  /**
   * 标签
   */
  private String label;

  /**
   * 职位描述
   */
  private String content1;

  /**
   * 职位要求
   */
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
