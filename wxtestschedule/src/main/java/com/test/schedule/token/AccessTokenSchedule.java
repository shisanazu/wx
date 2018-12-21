package com.test.schedule.token;

import com.test.service.tokenmanager.AccessTokenService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/15 0015.
 */
@Slf4j
@Component
@JobHandler("accessTokenSchedule")
public class AccessTokenSchedule extends IJobHandler{

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;

    @Autowired
    @Qualifier("jsAccessTokenServiceImpl")
    private AccessTokenService jsAccessTokenService;
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("accessTokenSchedule:{}",s);
        try {
            accessTokenService.obtainAccessToken();
            jsAccessTokenService.obtainAccessToken();
        } catch (Exception e) {
            log.error("获取微信access_token程序异常了",e);
            return IJobHandler.FAIL;
        }
        return IJobHandler.SUCCESS;
    }
}
