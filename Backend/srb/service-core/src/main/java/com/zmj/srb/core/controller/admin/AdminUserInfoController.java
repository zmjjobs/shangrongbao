package com.zmj.srb.core.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zmj.srb.common.result.R;
import com.zmj.srb.core.pojo.entity.UserInfo;
import com.zmj.srb.core.pojo.query.UserInfoQuery;
import com.zmj.srb.core.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
@RestController
@Api(tags = "会员管理")
@RequestMapping("/admin/core/userInfo")
@Slf4j
@CrossOrigin
public class AdminUserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @ApiOperation("获取会员分页列表")
    @GetMapping("/listPage/{page}/{limit}")
    public R listPage(
            @ApiParam(value = "当前页",required = true)
            @PathVariable Long page,
            @ApiParam(value = "每页记录数",defaultValue = "10")
            @PathVariable Long limit,
            @ApiParam(value = "查询对象")
            UserInfoQuery userInfoQuery
    ) {
        Page<UserInfo> pageParam = new Page<>(page,limit);
        IPage<UserInfo> pageModel =  userInfoService.listPage(pageParam,userInfoQuery);
        for (UserInfo user : pageModel.getRecords()) {
            user.setPassword(null);
        }
        return R.ok().data("pageModel",pageModel);
    }

    @PutMapping("/lock/{id}/{status}")
    @ApiOperation("锁定或解锁状态")
    public R lock(
            @ApiParam(value = "记录ID",required = true)
            @PathVariable("id")
            Long id,
            @ApiParam(value = "锁定状态(1:解锁 0:锁定)",required = true)
                    @PathVariable("status")
            Integer status) {
            int ret = userInfoService.lock(id,status);
            if (ret == 1) {
                return R.ok().message(status==1 ? "解锁成功":"锁定成功");
            }
            return R.ok().message("这条记录已被其他人修改，请确认");
    }

}

