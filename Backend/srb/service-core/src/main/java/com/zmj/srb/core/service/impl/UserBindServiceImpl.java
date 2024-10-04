package com.zmj.srb.core.service.impl;

import com.zmj.srb.core.pojo.entity.UserBind;
import com.zmj.srb.core.mapper.UserBindMapper;
import com.zmj.srb.core.pojo.vo.UserBindVO;
import com.zmj.srb.core.service.UserBindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 用户绑定表 服务实现类
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
@Service
public class UserBindServiceImpl extends ServiceImpl<UserBindMapper, UserBind> implements UserBindService {

    @Override
    public String commitBindUser(UserBindVO userBindVO, Long userId) {
        return null;
    }

    @Override
    public void notify(Map<String, Object> paramMap) {

    }
}
