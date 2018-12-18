package com.test.schedule.config;

import com.xxl.job.core.executor.XxlJobExecutor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/12/15 0015.
 */
@Configuration
public class XxlJobConfig {
    @Bean(value="xxlJobExecutor",initMethod = "start", destroyMethod = "destroy")
    @ConfigurationProperties(prefix = "xxl.job")
    public XxlJobExecutor init() {
        return new XxlJobExecutor();
    }
}
