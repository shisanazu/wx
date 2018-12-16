package com.test.schedule.token;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/12/15 0015.
 */
@Slf4j
@Component
@JobHandler("accessTokenSchedule")
public class AccessTokenSchedule extends IJobHandler{
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("accessTokenSchedule:{}",s);
        return null;
    }
}
