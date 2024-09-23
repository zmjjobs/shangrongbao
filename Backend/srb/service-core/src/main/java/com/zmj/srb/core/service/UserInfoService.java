package com.zmj.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zmj.srb.core.pojo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zmj.srb.core.pojo.query.UserInfoQuery;
import com.zmj.srb.core.pojo.vo.LoginVO;
import com.zmj.srb.core.pojo.vo.RegisterVO;
import com.zmj.srb.core.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
public interface UserInfoService extends IService<UserInfo> {

    void register(RegisterVO registerVO);

    UserInfoVO login(LoginVO loginVO);

    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);

    int lock(Long id, Integer status);

    boolean checkMobile(String mobile);
}
