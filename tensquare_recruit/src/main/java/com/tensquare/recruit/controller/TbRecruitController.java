package com.tensquare.recruit.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.recruit.entity.TbRecruit;
import com.tensquare.recruit.service.TbRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: 职位管理
 * @Author: cmj
 * @Date: 2022-03-31 16:56
 * @Version: V1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class TbRecruitController {

    @Autowired
    private TbRecruitService tbRecruitService;

    @PostMapping("/findSearch/{pageIndex}/{pageSize}")
    public Result findSearch(@RequestBody Map searchMap,
                             @PathVariable int pageIndex,
                             @PathVariable int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功！",
                tbRecruitService.findSearch(searchMap, pageIndex, pageSize));
    }

    /**
     * 查询全部列表
     *
     * @return 列表
     */
    @GetMapping("/findAll")
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", tbRecruitService.findAll());
    }

    /**
     * 根据状态2的查询
     *      查询状态为2并以创建日期降序排序，查询前4条记录
     * @return Result
     */
    @GetMapping("/findSearch/recommend")
    public Result recommend() {
        List<TbRecruit> list =
                tbRecruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 最新职位列表
     *      查询状态不为0并以创建日期降序排序，查询前12条记录
     * @return Result
     */
    @GetMapping("/findSearch/newList")
    public Result newList() {
        List<TbRecruit> list =
                tbRecruitService.newList("0");
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 根据ID查询标签
     *
     * @param id ID
     * @return 企业
     */
    @GetMapping(value = "/findById/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", tbRecruitService.findById(id));
    }

    /**
     * 增加企业
     *
     * @param tbRecruit 企业
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody TbRecruit tbRecruit) {
        tbRecruitService.add(tbRecruit);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 根据ID修改
     *
     * @param tbRecruit 企业
     * @param id        Id
     * @return 结果
     */
    @PutMapping(value = "/update/{id}")
    public Result update(@RequestBody TbRecruit tbRecruit, @PathVariable String id) {
        tbRecruit.setId(id);
        tbRecruitService.update(tbRecruit);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 根据ID删除
     *
     * @param id id
     * @return 结果
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public Result deleteById(@PathVariable String id) {
        tbRecruitService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
