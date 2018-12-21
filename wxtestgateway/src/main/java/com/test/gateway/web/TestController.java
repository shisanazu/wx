package com.test.gateway.web;

import com.test.service.authorize.AuthorizeService;
import com.test.service.news.NewsService;
import com.test.service.tokenmanager.AccessTokenService;
import com.test.service.wxMenu.WxMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("jsAccessTokenServiceImpl")
    private AccessTokenService accessTokenService;

    @Autowired
    private AuthorizeService authorizeService;

    @Autowired
    private WxMenuService wxMenuService;

    @Autowired
    private NewsService newsService;

    @RequestMapping("/one")
    @ResponseBody
    public Object todo(HttpServletRequest request, MultipartFile file) {
        System.out.println("------------");
        /*Enumeration<String> var333 = request.getHeaderNames();
        while (var333.hasMoreElements()) {
            System.out.println(request.getHeader(var333.nextElement()));
        }*/
        MultipartResolver resolver = new StandardServletMultipartResolver();
        MultipartHttpServletRequest mRequest = resolver.resolveMultipart(request);
        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> per : fileMap.entrySet()) {
            File var33 = new File("/tupian111.jpg");
            try {
                FileOutputStream outputStream = new FileOutputStream(var33);
                IOUtils.copy(per.getValue().getInputStream(),outputStream);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
    @RequestMapping("/two")
    public Object xxx (HttpServletRequest request) {
        // 生成签名
        /*Date now = new Date();
        Random random = new Random(1000000);
        Long nonceStr = random.nextLong();
        String signature = "";
        try {
            signature = SHA1.getJsSHA1(nonceStr.toString(),accessTokenService.getAccessToken(),String.valueOf(now.getTime()),"http://pwf6tb.natappfree.cc/test/two");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        request.setAttribute("appId", WxSubscribeBaseConstant.appId);
        request.setAttribute("timestamp", now.getTime());
        request.setAttribute("nonceStr", nonceStr);
        request.setAttribute("signature", signature);*/
        String code = request.getParameter("code");
        log.info("code------------->{}",code);
        String openid = authorizeService.getOpenId(code);
        log.info("openid------------->{}",openid);
        HttpSession session = request.getSession(true);
        session.setAttribute("openId",openid);
        return "index";
    }

    @RequestMapping("/three")
    public Object xxx1 (HttpServletRequest request) {
        wxMenuService.updateMenu();
        return "index";
    }
    @RequestMapping("/four")
    public Object xxx2 (HttpServletRequest request) {
        /*HttpSession session = request.getSession(true);
        Object xxx = session.getAttribute("openId");
        String code = request.getParameter("code");
        authorizeService.getUserInfo(code);*/
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        newsService.sendNews(null,null);
        return "four";
    }

}
