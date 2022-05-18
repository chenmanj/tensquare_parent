package com.tensquare.base.service;

import com.tensquare.base.dao.TbLabelDao;
import com.tensquare.base.entity.TbLabel;
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
 * @Description: 标签业务逻辑接口
 * @Author: cmj
 * @Date: 2022-03-03 09:57
 * @Version: V1.0
 */
@Service
public class TbLabelService {

    @Autowired
    private TbLabelDao tbLabelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     *
     * @return List<TbLabel>
     */
    public List<TbLabel> findAll() {
        return tbLabelDao.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @return TbLabel
     */
    public TbLabel findById(String id) {
        return tbLabelDao.findById(id).get();
    }

    /**
     * 增加标签
     *
     * @param tbLabel 标签
     */
    public void add(TbLabel tbLabel) {
        //设置ID
        tbLabel.setId(idWorker.nextId() + "");
        tbLabelDao.save(tbLabel);
    }

    /**
     * 修改标签
     *
     * @param tbLabel 标签
     */
    public void update(TbLabel tbLabel) {
        tbLabelDao.save(tbLabel);
    }

    /**
     * 删除标签
     *
     * @param id 标签id
     */
    public void deleteById(String id) {
        tbLabelDao.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return list
     */
    public List<TbLabel> findSearch(Map searchMap) {
        Specification<TbLabel> specification = createSpecification(searchMap);
        return tbLabelDao.findAll(specification);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap 查询条件
     * @return list集合
     */
    private Specification<TbLabel> createSpecification(Map searchMap) {
        return new Specification<TbLabel>() {
            @Override
            public Predicate toPredicate(Root<TbLabel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (null != searchMap.get("labelname") && !"".equals(searchMap.get("labelname"))) {
                    list.add(cb.like(root.get("labelname").as(String.class), "%" +
                            searchMap.get("labelname") + "%"));
                }
                if (null != searchMap.get("state") && !"".equals(searchMap.get("state"))) {
                    list.add(cb.like(root.get("state").as(String.class), "%" +
                            searchMap.get("state") + "%"));
                }
                if (null != searchMap.get("recommend") && !"".equals(searchMap.get("recommend"))) {
                    list.add(cb.like(root.get("recommend").as(String.class), "%" +
                            searchMap.get("recommend") + "%"));
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
    public Page<TbLabel> findSearch(Map searchMap, int pageIndex, int pageSize) {
        Specification<TbLabel> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return tbLabelDao.findAll(specification,pageRequest);
    }

}
