package com.tensquare.qa.service;

import com.tensquare.qa.dao.TbReplyDao;
import com.tensquare.qa.entity.TbReply;
import com.tensquare.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 回答业务接口
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @Version: V1.0
 */
@Service
public class TbReplyService {

    @Autowired
    private TbReplyDao tbReplyDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部回答
     *
     * @return List<TbReply>
     */
    public List<TbReply> findAll() {
        return tbReplyDao.findAll();
    }

    /**
     * 根据ID查询回答
     *
     * @return TbReply
     */
    public TbReply findById(String id) {
        return tbReplyDao.findById(id).get();
    }

    /**
     * 增加回答
     *
     * @param tbReply 回答
     */
    public void add(TbReply tbReply) {
        //设置ID
        tbReply.setId(idWorker.nextId() + "");
        tbReplyDao.save(tbReply);
    }

    /**
     * 修改回答
     *
     * @param tbReply 回答
     */
    public void update(TbReply tbReply) {
        tbReplyDao.save(tbReply);
    }

    /**
     * 删除回答
     *
     * @param id 回答id
     */
    public void deleteById(String id) {
        tbReplyDao.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return list
     */
    public List<TbReply> findSearch(Map searchMap) {
        Specification<TbReply> specification = createSpecification(searchMap);
        return tbReplyDao.findAll(specification);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap 查询条件
     * @return list集合
     */
    private Specification<TbReply> createSpecification(Map searchMap) {
        return new Specification<TbReply>() {
            @Override
            public Predicate toPredicate(Root<TbReply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (null != searchMap.get("content") && !"".equals(searchMap.get("content"))) {
                    list.add(cb.like(root.get("content").as(String.class), "%" +
                            searchMap.get("content") + "%"));
                }
                if (null != searchMap.get("nickname") && !"".equals(searchMap.get("nickname"))) {
                    list.add(cb.like(root.get("nickname").as(String.class), "%" +
                            searchMap.get("nickname") + "%"));
                }
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        };
    }

    /**
     * 分页查询
     * @param searchMap 查询条件
     * @param pageIndex 当前页面
     * @param pageSize 每页条数
     * @return 分页list
     */
    public Page<TbReply> findSearch(Map searchMap, int pageIndex, int pageSize) {
        Specification<TbReply> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return tbReplyDao.findAll(specification,pageRequest);
    }

}
