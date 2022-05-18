package com.tensquare.recruit.dao;

import com.tensquare.recruit.entity.TbEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Description: 企业管理dao接口
 * @Author: cmj
 * @Date: 2022-03-31 16:53
 * @Version: V1.0
 */
public interface TbEnterpriseDao extends JpaRepository<TbEnterprise, String>, JpaSpecificationExecutor<TbEnterprise> {

    /**
     * 根据热门状态获取企业列表
     * @param ishot ishot 热门状态
     * @return list
     */
    public List<TbEnterprise> findByIshot(String ishot);
}
