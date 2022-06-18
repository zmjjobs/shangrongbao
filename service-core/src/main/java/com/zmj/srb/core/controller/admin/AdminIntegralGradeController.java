package com.zmj.srb.core.controller.admin;


import com.zmj.common.exception.Assert;
import com.zmj.common.result.ResponseEnum;
import com.zmj.common.result.ResponseResult;
import com.zmj.srb.core.pojo.entity.IntegralGrade;
import com.zmj.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author ZMJ
 * @since 2021-12-24
 */
@CrossOrigin
@RestController
@Api(tags = "积分等级管理")
@RequestMapping("/admin/core/integralGrade")
public class AdminIntegralGradeController {

    @Resource
    private IntegralGradeService integralGradeService;

    @ApiOperation("积分等级列表")
    @GetMapping("/list")
    public ResponseResult listAll(){
        List<IntegralGrade> list = integralGradeService.list();
        return ResponseResult.success().data("list",list).message("获取列表成功");
    }

    @ApiOperation("根据ID积分等级")
    @GetMapping("/get/{id}")
    public ResponseResult getById(
            @ApiParam(value="主键ID",required = true)
            @PathVariable Long id
    ){
        IntegralGrade integralGrade = integralGradeService.getById(id);
        if (integralGrade != null) {
            return ResponseResult.success().data("record",integralGrade).message("根据ID获取积分等级成功");
        }
        return ResponseResult.error().message("根据ID获取积分等级失败");
    }

    @ApiOperation(value= "根据id删除记录",notes = "逻辑删除")
    @DeleteMapping("/remove/{id}")
    public ResponseResult removeById(
            @ApiParam(value="主键ID",required = true)
            @PathVariable Long id) {
        boolean success = integralGradeService.removeById(id);
        if (success) {
            return ResponseResult.success().message("删除成功");
        }
        return ResponseResult.error().message("删除失败");
    }

    @ApiOperation(value= "新增积分等级")
    @PostMapping("/save")
    public ResponseResult save(
            @ApiParam(value="积分等级对象",required = true)
            @RequestBody IntegralGrade integralGrade) {
        Assert.notNull(integralGrade.getBorrowAmount(),ResponseEnum.BORROW_AMOUNT_NULL_ERROR);

        boolean success = integralGradeService.save(integralGrade);
        if (success) {
            return ResponseResult.success().message("保存成功");
        }
        return ResponseResult.error().message("保存失败");
    }

    @ApiOperation(value= "根据ID更新积分等级")
    @PutMapping("/update")
    public ResponseResult updateById(
            @ApiParam(value="积分等级对象",required = true)
            @RequestBody IntegralGrade integralGrade) {
        boolean success = integralGradeService.updateById(integralGrade);
        if (success) {
            return ResponseResult.success().message("更新成功");
        }
        return ResponseResult.error().message("更新失败");
    }
}

