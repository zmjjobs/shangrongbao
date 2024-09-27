package com.zmj.srb.core.controller.admin;

import com.zmj.srb.common.result.R;
import com.zmj.srb.core.pojo.entity.UserLoginRecord;
import com.zmj.srb.core.service.UserLoginRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户登录记录表 前端控制器
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
@Api(tags = "会员登录日志接口")
@RestController
//@CrossOrigin
@RequestMapping("/admin/core/userLoginRecord")
public class AdminUserLoginRecordController {
    @Resource
    private UserLoginRecordService userLoginRecordService;

    private static final int topNum = 50;//默认显示条数

    @ApiOperation("获取会员登录日志最新50条记录")
    @GetMapping("/listTop/{userId}")
    public R listTop(
            @ApiParam(value = "用户ID",required = true)
            @PathVariable Long userId
            ){
        List<UserLoginRecord> list = userLoginRecordService.listTop(userId,topNum);
        return R.ok().data("records",list);
    }
}

