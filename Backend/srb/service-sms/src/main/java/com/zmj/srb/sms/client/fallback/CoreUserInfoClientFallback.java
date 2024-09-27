package com.zmj.srb.sms.client.fallback;

import com.zmj.srb.sms.client.CoreUserInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoreUserInfoClientFallback implements CoreUserInfoClient {
    @Override
    public boolean checkMobile(String mobile) {
        log.info("checkMobile远程调用失败，服务熔断");
        return false;//手机号不重复
    }
}
