package com.tensquare.qa.controller;

import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.qa.entity.TbProblem;
import com.tensquare.qa.service.TbProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description: 问题管理
 * @Author: cmj
 * @Date: 2022/4/18 11:16 上午
 * @Version: V1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class TbProblemController {

    @Autowired
    private TbProblemService tbProblemService;

    @PostMapping("/findSearch/{pageIndex}/{pageSize}")
    public Result findSearch(@RequestBody Map searchMap,
                             @PathVariable int pageIndex,
                             @PathVariable int pageSize) {
        return new Result(true, StatusCode.OK, "查询成功！",
                tbProblemService.findSearch(searchMap, pageIndex, pageSize));
    }

    /**
     * 根据标签ID查询最新问题列表
     * @param labelId 标签id
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return 结果
     */
    @PostMapping("/findNewListByLabelId/{labelId}/{pageIndex}/{pageSize}")
    public Result findNewListByLabelId(@PathVariable String labelId,
                                       @PathVariable int pageIndex,
                                       @PathVariable int pageSize) {
        Page<TbProblem> pageList = tbProblemService.findNewListByLabelId(labelId, pageIndex, pageSize);
        PageResult<TbProblem> pageResult = new PageResult<>
                (pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功！", pageResult);
    }

    /**
     *  根据标签ID查询热门问题列表
     * @param lableId 标签ID
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return Result
     */
    @PostMapping("/findHotListByLabelId/{labelId}/{pageIndex}/{pageSize}")
    public Result findHotListByLabelId(@PathVariable String lableId,
                                       @PathVariable int pageIndex,
                                       @PathVariable int pageSize) {
        Page<TbProblem> pageList =
                tbProblemService.findHotListByLabelId(lableId, pageIndex, pageSize);
        PageResult<TbProblem> pageResult = new PageResult<>
                (pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     *  根据标签ID查询等待回答列表
     * @param lableId 标签ID
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return Result
     */
    @PostMapping("/findWaitListByLabelId/{labelId}/{pageIndex}/{pageSize}")
    public Result findWaitListByLabelId(@PathVariable String lableId,
                                       @PathVariable int pageIndex,
                                       @PathVariable int pageSize) {
        Page<TbProblem> pageList =
                tbProblemService.findWaitListByLabelId(lableId, pageIndex, pageSize);
        PageResult<TbProblem> pageResult = new PageResult<>
                (pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 查询全部列表
     *
     * @return 列表
     */
    @GetMapping("/findAll")
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", tbProblemService.findAll());
    }


    /**
     * 根据ID查询问题
     *
     * @param id ID
     * @return 问题
     */
    @GetMapping(value = "/findById/{id}")
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", tbProblemService.findById(id));
    }

    /**
     * 增加问题
     *
     * @param tbProblem 问题
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody TbProblem tbProblem) {
        tbProblemService.add(tbProblem);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 根据ID修改
     *
     * @param tbProblem 问题
     * @param id      Id
     * @return 结果
     */
    @PutMapping(value = "/update/{id}")
    public Result update(@RequestBody TbProblem tbProblem, @PathVariable String id) {
        tbProblem.setId(id);
        tbProblemService.update(tbProblem);
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
        tbProblemService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
