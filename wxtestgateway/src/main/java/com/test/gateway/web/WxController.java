package com.test.gateway.web;

import com.test.common.vo.WxReqParamVo;
import com.test.service.messagehandle.WxRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/12/15 0015.
 */
@Slf4j
@RestController
@RequestMapping(value = "/wx")
public class WxController {

    @Autowired
    private WxRouteService wxRouteService;
    @RequestMapping("/wxservice")
    @ResponseBody
    public Object wxService(HttpServletRequest request) {
        return wxRouteService.preRoute(new WxReqParamVo(request));
    }
}
