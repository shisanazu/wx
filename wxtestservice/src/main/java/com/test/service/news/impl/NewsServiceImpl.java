package com.test.service.news.impl;

import com.alibaba.fastjson.JSONObject;
import com.test.common.constant.WxApiConstant;
import com.test.common.dao.news.WxNewsMapper;
import com.test.common.model.news.WxNews;
import com.test.common.util.RestfulClient;
import com.test.common.vo.ResCommon;
import com.test.service.news.NewsService;
import com.test.service.tokenmanager.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    @Qualifier("accessTokenServiceImpl")
    private AccessTokenService accessTokenService;

    @Autowired
    private WxNewsMapper wxNewsMapper;
    @Override
    public ResCommon<JSONObject> sendNews(String mediaId, List<String> openIdList) {
        JSONObject dataWap = new JSONObject();
        JSONObject mpnews = new JSONObject();
        mpnews.put("media_id","-vM0cCjL7VSG9taSlGfiKwvJttS7-Y6S09HnS2jJEASMsh1hSV_N5WJx1ufL07Cw");
        dataWap.put("mpnews",mpnews);
        dataWap.put("msgtype","mpnews");
        dataWap.put("touser", "oDHSQ1suKp1AUwcCO8WMnTCmwnTM");
        String param = JSONObject.toJSONString(dataWap);
        String var1 = RestfulClient.postJson("https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token={1}", String.class,param, accessTokenService.getAccessToken());
        System.out.println(var1);
        return null;
    }
    @Override
    public ResCommon<JSONObject> addNews(List<Long> list) {
        List<WxNews> listdata = new ArrayList<>();
        list.stream().forEach((a)->{
            listdata.add(wxNewsMapper.selectByPrimaryKey(a));
        });
        JSONObject dataWap = new JSONObject();
        dataWap.put("articles", listdata);
        String param = JSONObject.toJSONString(dataWap);
        String var1 = RestfulClient.postJson(WxApiConstant.ResourcesApi.ADD, String.class,param, accessTokenService.getAccessToken());
        JSONObject josn = JSONObject.parseObject(var1);
        System.out.println(var1);
        return null;
    }
}
