package com.tensquare.qa.dao;

import com.tensquare.qa.entity.TbReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @Description: 回答管理dao接口
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @Version: V1.0
 */
public interface TbReplyDao extends JpaRepository<TbReply, String>, JpaSpecificationExecutor<TbReply> {

}
