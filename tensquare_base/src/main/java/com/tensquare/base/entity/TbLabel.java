package com.tensquare.base.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * @version v1.0
 * @Description: 标签实体类
 * @Author: cmj
 * @Date: 2022/3/2 6:00 下午
 */


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "tb_label")
public class TbLabel implements Serializable {
    @Id
    private String id;

    /**
     * 标签名称
     */
    private String labelname;

    /**
     * 状态
     */
    private String state;

    /**
     * 使用数量
     */
    private Integer count;

    /**
     * 关注数
     */
    private String recommend;

    /**
     * 是否推荐
     */
    private Integer fans;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        TbLabel tbLabel = (TbLabel) o;
        return id != null && Objects.equals(id, tbLabel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
