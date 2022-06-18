package com.zmj.srb.core.service.impl;

import com.zmj.srb.core.pojo.entity.UserAccount;
import com.zmj.srb.core.mapper.UserAccountMapper;
import com.zmj.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author ZMJ
 * @since 2021-12-24
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
