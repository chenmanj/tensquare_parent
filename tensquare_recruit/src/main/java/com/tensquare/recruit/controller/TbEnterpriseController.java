package com.tensquare.recruit.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.recruit.entity.TbEnterprise;
import com.tensquare.recruit.service.TbEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 企业管理
 * @Author: cmj
 * @Date: 2022-03-31 16:56
 * @Version: V1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class TbEnterpriseController {

    @Autowired
    private TbEnterpriseService tbEnterpriseService;

    @PostMapping("/findSearch/{pageIndex}/{pageSize}")
    public Result findSearch(@RequestBody Map searchMap,
                             @PathVariable int pageIndex,
                             @PathVariable int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功！",
                tbEnterpriseService.findSearch(searchMap, pageIndex, pageSize));
    }

    /**
     * 查询全部列表
     *
     * @return 列表
     */
    @GetMapping("/findAll")
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", tbEnterpriseService.findAll());
    }

    /**
     * 查询热门企业
     * @return 列表
     */
    @GetMapping("/findSearch/hotlist")
    public Result hotlist(){
        return new Result(true, StatusCode.OK, "查询成功", tbEnterpriseService.hotlist());
    }

    /**
     * 根据ID查询标签
     *
     * @param id ID
     * @return 企业
     */
    @GetMapping(value = "/findById/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", tbEnterpriseService.findById(id));
    }

    /**
     * 增加企业
     *
     * @param tbEnterprise 企业
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody TbEnterprise tbEnterprise) {
        tbEnterpriseService.add(tbEnterprise);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 根据ID修改
     *
     * @param tbEnterprise 企业
     * @param id      Id
     * @return 结果
     */
    @PutMapping(value = "/update/{id}")
    public Result update(@RequestBody TbEnterprise tbEnterprise, @PathVariable String id) {
        tbEnterprise.setId(id);
        tbEnterpriseService.update(tbEnterprise);
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
        tbEnterpriseService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
