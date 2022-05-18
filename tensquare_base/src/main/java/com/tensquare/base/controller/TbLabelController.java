package com.tensquare.base.controller;

import com.tensquare.base.entity.TbLabel;
import com.tensquare.base.service.TbLabelService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Description: 标签控制层
 * @Author: cmj
 * @Date: 2022-03-03 10:13
 * @Version: V1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class TbLabelController {

    @Autowired
    private TbLabelService tbLabelService;

    @PostMapping("/findSearch/{pageIndex}/{pageSize}")
    public Result findSearch(@RequestBody Map searchMap,
                             @PathVariable int pageIndex,
                             @PathVariable int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功！",
                tbLabelService.findSearch(searchMap, pageIndex, pageSize));
    }

    /**
     * 查询全部列表
     *
     * @return 列表
     */
    @GetMapping("/findAll")
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", tbLabelService.findAll());
    }

    /**
     * 根据ID查询标签
     *
     * @param id ID
     * @return 标签
     */
    @GetMapping(value = "/findById/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", tbLabelService.findById(id));
    }

    /**
     * 增加标签
     *
     * @param tbLabel 标签
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody TbLabel tbLabel) {
        tbLabelService.add(tbLabel);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 根据ID修改
     *
     * @param tbLabel 标签
     * @param id      Id
     * @return 结果
     */
    @PutMapping(value = "/update/{id}")
    public Result update(@RequestBody TbLabel tbLabel, @PathVariable String id) {
        tbLabel.setId(id);
        tbLabelService.update(tbLabel);
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
        tbLabelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
