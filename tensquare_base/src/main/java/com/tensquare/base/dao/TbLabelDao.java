package com.tensquare.base.dao;

import com.tensquare.base.entity.TbLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description: 标签 Dao
 * @Author: cmj
 * @Date: 2022-03-03 09:53
 * @Version: V1.0
 */
public interface TbLabelDao extends JpaRepository<TbLabel, String>, JpaSpecificationExecutor<TbLabel> {

}
