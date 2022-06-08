package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.TbRecruitDao;
import com.tensquare.recruit.entity.TbRecruit;
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
 * @Description: 职位业务接口
 * @Author: cmj
 * @Date: 2022-03-31 16:55
 * @Version: V1.0
 */
@Service
public class TbRecruitService {

    @Autowired
    private TbRecruitDao tbRecruitDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部职位
     *
     * @return List<TbRecruit>
     */
    public List<TbRecruit> findAll() {
        return tbRecruitDao.findAll();
    }

    /**
     * 根据ID查询职位
     *
     * @return TbRecruit
     */
    public TbRecruit findById(String id) {
        return tbRecruitDao.findById(id).get();
    }

    /**
     * 增加职位
     *
     * @param tbRecruit 职位
     */
    public void add(TbRecruit tbRecruit) {
        //设置ID
        tbRecruit.setId(idWorker.nextId() + "");
        tbRecruitDao.save(tbRecruit);
    }

    /**
     * 修改职位
     *
     * @param tbRecruit 职位
     */
    public void update(TbRecruit tbRecruit) {
        tbRecruitDao.save(tbRecruit);
    }

    /**
     * 删除职位
     *
     * @param id 职位id
     */
    public void deleteById(String id) {
        tbRecruitDao.deleteById(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap 查询条件
     * @return list
     */
    public List<TbRecruit> findSearch(Map searchMap) {
        Specification<TbRecruit> specification = createSpecification(searchMap);
        return tbRecruitDao.findAll(specification);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap 查询条件
     * @return list集合
     */
    private Specification<TbRecruit> createSpecification(Map searchMap) {
        return new Specification<TbRecruit>() {
            @Override
            public Predicate toPredicate(Root<TbRecruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
    public Page<TbRecruit> findSearch(Map searchMap, int pageIndex, int pageSize) {
        Specification<TbRecruit> specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(pageIndex - 1, pageSize);
        return tbRecruitDao.findAll(specification,pageRequest);
    }

    /**
     * 根据状态查询
     * @param state 状态
     * @return  List<TbRecruit>
     */
    public List<TbRecruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return tbRecruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 最新职位列表
     * @param state 状态
     * @return list
     */
    public List<TbRecruit> newList(String state) {
        return tbRecruitDao.findTop12ByStateNotOrderByCreatetimeDesc(state);
    }

}
