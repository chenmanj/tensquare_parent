package com.tensquare.qa.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.qa.entity.TbReply;
import com.tensquare.qa.service.TbReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 回答管理
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @Version: V1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/reply")
public class TbReplyController {

    @Autowired
    private TbReplyService tbReplyService;

    @PostMapping("/findSearch/{pageIndex}/{pageSize}")
    public Result findSearch(@RequestBody Map searchMap,
                             @PathVariable int pageIndex,
                             @PathVariable int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功！",
                tbReplyService.findSearch(searchMap, pageIndex, pageSize));
    }

    /**
     * 查询全部列表
     *
     * @return 列表
     */
    @GetMapping("/findAll")
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", tbReplyService.findAll());
    }


    //需求分析:最新回复的问题显示在上方， 按回复时间降序排序。


    /**
     * 根据ID查询问题
     *
     * @param id ID
     * @return 回答
     */
    @GetMapping(value = "/findById/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", tbReplyService.findById(id));
    }

    /**
     * 增加回答
     *
     * @param tbReply 回答
     * @return 结果
     */
    @PostMapping("/add")
    public Result add(@RequestBody TbReply tbReply) {
        tbReplyService.add(tbReply);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 根据ID修改
     *
     * @param tbReply 回答
     * @param id      Id
     * @return 结果
     */
    @PutMapping(value = "/update/{id}")
    public Result update(@RequestBody TbReply tbReply, @PathVariable String id) {
        tbReply.setId(id);
        tbReplyService.update(tbReply);
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
        tbReplyService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
