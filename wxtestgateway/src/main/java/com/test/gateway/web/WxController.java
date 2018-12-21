package com.test.gateway.web;

import com.alibaba.fastjson.JSONObject;
import com.test.common.vo.WxReqParamVo;
import com.test.service.h5Message.H5MessageService;
import com.test.service.messagehandle.WxRouteService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private H5MessageService h5MessageService;

    @RequestMapping("/wxservice")
    @ResponseBody
    public Object wxService(HttpServletRequest request) {
        return wxRouteService.preRoute(new WxReqParamVo(request));
    }

    @RequestMapping("/notice")
    @ResponseBody
    public Object notice(@RequestParam("type") String type,@RequestParam("media_id") String mediaId) {
        log.info("type:{},media_id:{}", type,mediaId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type",type);
        jsonObject.put("mediaId", mediaId);
        return h5MessageService.service(jsonObject);
    }
}
