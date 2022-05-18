package com.tensquare.qa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 回答
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @version v1.0
 */
@Setter
@Getter
@Entity
@Table(name = "tb_reply")
public class TbReply implements Serializable {

  @Id
  private String id;

  private String problemid;

  private String content;

  private Date createtime;

  private Date updatetime;

  private String userid;

  private String nickname;
}
