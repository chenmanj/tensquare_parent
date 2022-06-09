package com.tensquare.qa.dao;

import com.tensquare.qa.entity.TbProblem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


/**
 * @Description: 问题管理dao接口
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @Version: V1.0
 */
public interface TbProblemDao extends JpaRepository<TbProblem, String>, JpaSpecificationExecutor<TbProblem> {

    /**
     * 根据标签ID查询最新问题列表
     * @param labelId 标签id
     * @param pageable 分页
     * @return Page<TbProblem>
     */
    @Query("select p from TbProblem p where p.id in( select problemid from TbPl " +
            "where labelid=?1 ) order by p.replytime desc")
    Page<TbProblem> findNewListByLabelId(String labelId, Pageable pageable);

    /**
     * 根据标签ID查询热门问题列表
     *      按回复数降序排序
     * @param lableId 标签id
     * @param pageRequest 分页
     * @return Page<TbProblem>
     */
    @Query("select p from TbProblem p where p.id in( select problemid from TbPl " +
            "where labelid=?1 ) order by p.reply desc")
    Page<TbProblem> findHotListByLabelId(String lableId, PageRequest pageRequest);

    /**
     * 根据标签ID查询等待回答列表
     * @param lableId 标签id
     * @param pageRequest 分页
     * @return Page<TbProblem>
     */
    @Query("select p from TbProblem p where p.id in( select problemid from TbPl " +
            "where labelid=?1 ) and p.reply = 0 order by p.createtime desc")
    Page<TbProblem> findWaitListByLabelId(String lableId, PageRequest pageRequest);

}
