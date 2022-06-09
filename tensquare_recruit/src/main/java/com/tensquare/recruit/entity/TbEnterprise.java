package com.tensquare.recruit.entity;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * 企业
 */
@Setter
@Getter
@Entity
@Table(name = "tb_enterprise")
public class TbEnterprise implements Serializable {

  @Id
  private String id;

  /**
   * 企业名称
   */
  private String name;

  /**
   * 企业简介
   */
  private String summary;

  /**
   * 企业地址
   */
  private String address;

  /**
   * 标签列表（用逗号分隔）
   */
  private String labels;

  /**
   * 企业位置坐标（经度，纬度）
   */
  private String coordinate;

  /**
   * 是否热门（0:非热门 1:热门）
   */
  private String ishot;

  /**
   * LOGO
   */
  private String logo;

  /**
   * 职位数
   */
  private Integer jobcount;

  /**
   * URL
   */
  private String url;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    TbEnterprise tbEnterprise = (TbEnterprise) o;
    return id != null && Objects.equals(id, tbEnterprise.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
