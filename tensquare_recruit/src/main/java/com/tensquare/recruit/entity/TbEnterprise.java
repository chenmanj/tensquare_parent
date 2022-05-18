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
  private String name;
  private String summary;
  private String address;
  private String labels;
  private String coordinate;
  private String ishot;
  private String logo;
  private long jobcount;
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
