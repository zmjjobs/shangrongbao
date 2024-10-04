package com.zmj.srb.core.controller.api;

import com.alibaba.fastjson.JSON;
import com.zmj.srb.base.util.JwtUtils;
import com.zmj.srb.common.result.R;
import com.zmj.srb.core.hfb.RequestHelper;
import com.zmj.srb.core.pojo.vo.UserBindVO;
import com.zmj.srb.core.service.UserBindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "会员账号绑定")
@RestController
@RequestMapping("/api/core/userBind")
@Slf4j
public class UserBindController {

    @Resource
    private UserBindService userBindService;

    @ApiOperation("账户绑定提交数据")
    @PostMapping("/auth/bind")
    public R bind(@RequestBody UserBindVO userBindVO, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long userId = JwtUtils.getUserId(token);
        String formStr = userBindService.commitBindUser(userBindVO, userId);
        return R.ok().data("formStr", formStr);
    }

    @ApiOperation("汇付宝账户绑定后异步回调")
    @PostMapping("/notify")
    public String notify(HttpServletRequest request) {
        Map<String, Object> paramMap = RequestHelper.switchMap(request.getParameterMap());
        log.info("汇付宝账户绑定后异步回调 接收参数如下："+ JSON.toJSONString(paramMap));
        //验签
        if (!RequestHelper.isSignEquals(paramMap)) {
            log.error("用户账号绑定异步回调签名验证错误！");
            return "fail";
        }
        log.info("用户账号绑定异步回调签名验证成功，开始账户绑定");
        userBindService.notify(paramMap);
        return "success";
    }
}