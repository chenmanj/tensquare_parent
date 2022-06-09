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

  /**
   * 问题ID
   */
  private String problemid;

  /**
   * 回答内容
   */
  private String content;

  /**
   * 回答日期
   */
  private Date createtime;

  /**
   * 更新日期
   */
  private Date updatetime;

  /**
   * 回答人ID
   */
  private String userid;

  /**
   * 回答人昵称
   */
  private String nickname;
}
