package com.tensquare.recruit.dao;

import com.tensquare.recruit.entity.TbRecruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Description: 职位管理dao接口
 * @Author: cmj
 * @Date: 2022-03-31 16:53
 * @Version: V1.0
 */
public interface TbRecruitDao extends JpaRepository<TbRecruit, String>, JpaSpecificationExecutor<TbRecruit> {

    /**
     * 查询最新职位列表(按创建日期降序排序)
     * @param state 状态
     * @return  List<TbRecruit>
     */
    List<TbRecruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 最新职位列表
     * @param state 状态
     * @return list
     */
    List<TbRecruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
