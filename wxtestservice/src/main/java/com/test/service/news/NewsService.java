package com.test.service.news;

import com.alibaba.fastjson.JSONObject;
import com.test.common.vo.ResCommon;

import java.util.List;

public interface NewsService {
    ResCommon<JSONObject> sendNews(String mediaId, List<String> openIdList);
    ResCommon<JSONObject> addNews(List<Long> list);

}
