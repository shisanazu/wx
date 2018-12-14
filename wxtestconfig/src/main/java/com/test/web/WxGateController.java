package com.test.web;

import com.test.service.WxRouteService;
import com.test.vo.WxReqParamVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/wx")
public class WxGateController {

    @Autowired
    private WxRouteService wxRouteService;

    @RequestMapping("/api/checktoken")
    @ResponseBody
    public Object check(HttpServletRequest request) {
        WxReqParamVo var1 = new WxReqParamVo(request);
       return wxRouteService.preRoute(var1);
    }

    @RequestMapping("/api/page")
    public Object page(HttpServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        log.info("code --------->{}", code);
        log.info("state --------->{}", state);
        return "index";
    }
}
