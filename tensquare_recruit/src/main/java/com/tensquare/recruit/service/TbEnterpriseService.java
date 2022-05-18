package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.TbEnterpriseDao;
import com.tensquare.recruit.entity.TbEnterprise;
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
 * @Description: 企业业务接口
 * @Author: cmj
 * @Date: 2022-03-31 16:55
 * @Version: V1.0
 */
@Service
public class TbEnterpriseService {

    @Autowired
    private TbEnterpriseDao tbEnterpriseDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部企业
     *
     * @return List<TbEnterprise>
     */
    public List<TbEnterprise> findAll() {
        return tbEnterpriseDao.findAll();
    }

    /**
     * 根据ID查询企业
     *
     * @return TbEnterprise
     */
    public TbEnterprise findById(String id) {
        return tbEnterpriseDao.findById(id).get();
    }

    /**
     * 增加企业
     *
     * @param tbEnterprise 企业
     */
    public void add(TbEnterprise tbEnterprise) {
        //设置ID
        tbEnterprise.setId(idWorker.nextId() + "");
        tbEnterpriseDao.save(tbEnterprise);
    }

    /**
     * 修改企业
     *
     * @param tbEnterprise 企业
     */
    public void update(TbEnterprise tbEnterprise) {
        tbEnterpriseDao.save(tbEnterprise);
    }

    /**
     * 删除企业
     *
     * @param id 企业id
     */
    public void deleteById(String id) {
        tbEnterpriseDao.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return list
     */
    public List<TbEnterprise> findSearch(Map searchMap) {
        Specification<TbEnterprise> specification = createSpecification(searchMap);
        return tbEnterpriseDao.findAll(specification);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap 查询条件
     * @return list集合
     */
    private Specification<TbEnterprise> createSpecification(Map searchMap) {
        return new Specification<TbEnterprise>() {
            @Override
            public Predicate toPredicate(Root<TbEnterprise> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (null != searchMap.get("name") && !"".equals(searchMap.get("name"))) {
                    list.add(cb.like(root.get("name").as(String.class), "%" +
                            searchMap.get("name") + "%"));
                }
                if (null != searchMap.get("summary") && !"".equals(searchMap.get("summary"))) {
                    list.add(cb.like(root.get("summary").as(String.class), "%" +
                            searchMap.get("summary") + "%"));
                }
                if (null != searchMap.get("address") && !"".equals(searchMap.get("address"))) {
                    list.add(cb.like(root.get("address").as(String.class), "%" +
                            searchMap.get("address") + "%"));
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
    public Page<TbEnterprise> findSearch(Map searchMap, int pageIndex, int pageSize) {
        Specification<TbEnterprise> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return tbEnterpriseDao.findAll(specification,pageRequest);
    }

    /**
     * 热门企业列表
     * @return list
     */
    public List<TbEnterprise> hotlist(){
        return tbEnterpriseDao.findByIshot("1");
    }
}
