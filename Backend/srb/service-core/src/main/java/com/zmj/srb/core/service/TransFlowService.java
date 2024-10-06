package com.zmj.srb.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zmj.srb.core.pojo.bo.TransFlowBO;
import com.zmj.srb.core.pojo.entity.TransFlow;

import java.util.List;

/**
 * <p>
 * 交易流水表 服务类
 * </p>
 *
 * @author zhumengjun
 * @since 2023-11-07
 */
public interface TransFlowService extends IService<TransFlow> {
    void saveTransFlow(TransFlowBO transFlowBO);

    boolean isSaveTransFlow(String agentBillNo);

    List<TransFlow> selectByUserId(Long userId);
}
