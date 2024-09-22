package com.zmj.srb.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zmj.srb.core.mapper.UserLoginRecordMapper;
import com.zmj.srb.core.pojo.entity.UserLoginRecord;
import com.zmj.srb.core.service.UserLoginRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements UserLoginRecordService {

    @Override
    public List<UserLoginRecord> listTop(Long userId, int topNum) {
        QueryWrapper<UserLoginRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).orderByDesc("id");
        if (topNum > 0) {
            queryWrapper.last("limit " + topNum);
        }
        return baseMapper.selectList(queryWrapper);
    }
}
