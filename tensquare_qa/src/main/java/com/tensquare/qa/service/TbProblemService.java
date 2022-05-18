package com.tensquare.qa.service;

import com.tensquare.qa.dao.TbProblemDao;
import com.tensquare.qa.entity.TbProblem;
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
 * @Description: 问题业务接口
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @Version: V1.0
 */
@Service
public class TbProblemService {

    @Autowired
    private TbProblemDao tbProblemDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部问题
     *
     * @return List<TbProblem>
     */
    public List<TbProblem> findAll() {
        return tbProblemDao.findAll();
    }

    /**
     * 根据ID查询问题
     *
     * @return TbProblem
     */
    public TbProblem findById(String id) {
        return tbProblemDao.findById(id).get();
    }

    /**
     * 增加问题
     *
     * @param tbProblem 问题
     */
    public void add(TbProblem tbProblem) {
        //设置ID
        tbProblem.setId(idWorker.nextId() + "");
        tbProblemDao.save(tbProblem);
    }

    /**
     * 修改问题
     *
     * @param tbProblem 问题
     */
    public void update(TbProblem tbProblem) {
        tbProblemDao.save(tbProblem);
    }

    /**
     * 删除问题
     *
     * @param id 问题id
     */
    public void deleteById(String id) {
        tbProblemDao.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return list
     */
    public List<TbProblem> findSearch(Map searchMap) {
        Specification<TbProblem> specification = createSpecification(searchMap);
        return tbProblemDao.findAll(specification);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap 查询条件
     * @return list集合
     */
    private Specification<TbProblem> createSpecification(Map searchMap) {
        return new Specification<TbProblem>() {
            @Override
            public Predicate toPredicate(Root<TbProblem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (null != searchMap.get("title") && !"".equals(searchMap.get("title"))) {
                    list.add(cb.like(root.get("title").as(String.class), "%" +
                            searchMap.get("title") + "%"));
                }
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
    public Page<TbProblem> findSearch(Map searchMap, int pageIndex, int pageSize) {
        Specification<TbProblem> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return tbProblemDao.findAll(specification,pageRequest);
    }

    /**
     * 根据标签ID查询问题列表
     * @param labelId 标签ID
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return
     */
    public Page<TbProblem> findNewListByLabelId(String labelId, int pageIndex, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return tbProblemDao.findNewListByLabelId(labelId, pageRequest);
    }


}
