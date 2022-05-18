package com.tensquare.qa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description:
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @version v1.0
 */
@Setter
@Getter
@Entity
@Table(name = "tb_ul")
public class TbUl implements Serializable {

  @Id
  private String uid;

  @Id
  private String lid;
}
