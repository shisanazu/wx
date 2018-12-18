package com.test.common.constant;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class WxApiConstant {

    public static class BaseApi {
        // 获取access_token
        public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={1}&secret={2}";
    }

    public static class MenuApi {
        // 创建菜单
        public static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={1}";
        // 删除菜单
        public static final String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={1}";
        // 查询菜单
        public static final String GET_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token={1}";
        // 创建个性化菜单
        public static final String CONDITIONAL_MENU = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token={1}";

    }
    public static class CustomServiceApi {
        // 添加客服
        public static final String ADD = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token={1}";
        // 查询客服
        public static final String QUERY = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token={1}";
        // 发送消息
        public static final String SEND = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token={1}";
        // 正在输入或者取消
        public static final String SENDING_CANCLE = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token={1}";

    }

    public static class AuthorizeApi {
        // 微信授权页面
        public static final String AUTHORIZE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={1}&redirect_uri={2}&response_type=code&scope={3}&state={4}";
        // 获取access_token
        public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={1}&secret={2}&code={3}&grant_type=authorization_code";
        //获取用户信息
        public static final String USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token={1}&openid={2}&lang=zh_CN";
    }

    public static class ResourcesApi {
        // 上传图文消息素材
        public static final String ADD = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token={1}";
        // 上传文件等图片等
        public static final String MULTIPART_ADD = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token={1}&type={2}";
    }

    public static class MessageSendApi {
        // 发送消息  和发送客服消息有点类似的
        public static final String SEND = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token={1}";
        // 消息预览
        public static final String PREVIEW = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token={1}";
    }
    public static class MessageTemplateApi {
        // 发送模板消息
        public static final String Send = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={1}";
    }

    public static class QrcodeApi {
        // 生成二维码
        public static final String CREATE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token={1}";

        // 获取二维码
        public static final String GET = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket={1}";
    }

    public static class CardApi {
        // 生成卡券
        public static final String CREATE = "https://api.weixin.qq.com/card/create?access_token={1}";

        // 生成二维码
        public static final String GET_QR = "https://api.weixin.qq.com/card/qrcode/create?access_token={1}";
        // 核销接口
        public static final String USE = "https://api.weixin.qq.com/card/code/consume?access_token={1}";
        //更新卡券
        public static final String UPDATE = "https://api.weixin.qq.com/card/update?access_token={1}";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        /*"kf_account" : "test1@test",
                "nickname" : "客服1"*/
        /*Map<String, String> param = new HashMap<>();
        param.put("kf_account", "test1@test");
        param.put("nickname", "客服1");
        param.put("password", "pswmd5");
        //String res = RestfulClient.postJson(CustomServiceApi.ADD, String.class, JSONObject.toJSONString(param),WxSubscribeBaseConstant.access_token);
        String res  = RestfulClient.getJson("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token={1}",String.class,WxSubscribeBaseConstant.access_token);*/

        Map<String, Object> param = new HashMap<>();
        /*{
            "touser":"OPENID",
                "msgtype":"news",
                "news":{
            "articles": [
            {
                "title":"Happy Day",
                    "description":"Is Really A Happy Day",
                    "url":"URL",
                    "picurl":"PIC_URL"
            }
         ]
        }
        }*/

        /*param.put("touser", "oDHSQ1suKp1AUwcCO8WMnTCmwnTM");
        param.put("msgtype","news");
        JSONObject jsonObject = new JSONObject();
        JSONArray var1 = new JSONArray();
        JSONObject tupian = new JSONObject();
        tupian.put("title","Happy Day");
        tupian.put("description","Is Really A Happy Day");
        tupian.put("url","http://amaayt.natappfree.cc/wx/api/page");
        tupian.put("picurl","http://amaayt.natappfree.cc/pictrue/11234567.jpg");
        var1.add(tupian);
        jsonObject.put("articles",var1);
        param.put("news",jsonObject);
        String res  = RestfulClient.postJson(CustomServiceApi.SEND,String.class,JSONObject.toJSONString(param),WxSubscribeBaseConstant.access_token);
        System.out.println(res);*/
        // NSs8lqB4Pixd8iUnlni3I2oi8XVsCl4epPe00uboNdMd2Q5HP314rhfd30ZWgH18 图片
        // _tvgR66UspO8Q9KI8bIhPWhIfYlbuF8V2CEh_kx9eHukP3jCJgGl1ucf-66-p8Me 消息
       /* String xxx = "{\"articles\":[{\"thumb_media_id\":\"NSs8lqB4Pixd8iUnlni3I2oi8XVsCl4epPe00uboNdMd2Q5HP314rhfd30ZWgH18\"," +
                "\"author\":\"azu\",\"title\":\"just test\",\"content_source_url\":\"http://amaayt.natappfree.cc/wx/api/page\"," +
                "\"content\":\"hello today\"," +
                "\"digest\":\"摘要\",\"show_cover_pic\":1,\"need_open_comment\":1,\"only_fans_can_comment\":0}]}";*/
        // String xxx = "{\"filter\":{\"is_to_all\":true},\"mpnews\":{\"media_id\":\"_tvgR66UspO8Q9KI8bIhPWhIfYlbuF8V2CEh_kx9eHukP3jCJgGl1ucf-66-p8Me\"},\"msgtype\":\"mpnews\",\"send_ignore_reprint\":0}";
        //String xxx = "{\"touser\":\"oDHSQ1suKp1AUwcCO8WMnTCmwnTM\",\"mpnews\":{\"media_id\":\"_tvgR66UspO8Q9KI8bIhPWhIfYlbuF8V2CEh_kx9eHukP3jCJgGl1ucf-66-p8Me\"},\"msgtype\":\"mpnews\"}";

       /* String var22 = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={1}";
        String xxx = "{\"touser\":\"oDHSQ1suKp1AUwcCO8WMnTCmwnTM\",\"template_id\":\"aPQJmjpGtAdfmMDtw_ovZ1KCUM5jmDKmfi05lrRSWCs\",\"data\":{\"name\":{\"value\":\"张三\",\"color\":\"#173177\"},\"date\":{\"value\":\"20181214\",\"color\":\"#f948f7\"}}}";*/
        // gQEw8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyTTdNQ2g2Y1FlZ20xNHpfc3hzMXQAAgSjRBNcAwSAOgkA
       /*String xxx = "{\"expire_seconds\":604800,\"action_name\":\"QR_SCENE\",\"action_info\":{\"scene\":{\"scene_id\":45678}}}";
       String res  = RestfulClient.postJson(QrcodeApi.CREATE,String.class,xxx,WxSubscribeBaseConstant.access_token);
        System.out.println(res);*/


        // 卡券 logo
        //  http://mmbiz.qpic.cn/mmbiz_jpg/0KfniaLO2vHwSZ9Syg9ibDaic94ycxfhlfqiczaQJsiaqp6qau1yYC1maJkFEZg5wJvficQz60BmNzkIrmZiajs3S7ppw/0
        // 卡券 pDHSQ1qy1k_fwVXiHBCiURjq3ESE  card_id
        // ticket gQEC7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAySjZwdWdXY1FlZ20xNU50ak5zNFMAAgRpVhNcAwQIBwAA
        // http:\/\/weixin.qq.com\/q\/02J6pugWcQegm15NtjNs4S 地址
        // String xxx1 = "{\"card\":{\"card_type\":\"GROUPON\",\"groupon\":{\"base_info\":{\"logo_url\":\"http://mmbiz.qpic.cn/mmbiz_jpg/0KfniaLO2vHwSZ9Syg9ibDaic94ycxfhlfqiczaQJsiaqp6qau1yYC1maJkFEZg5wJvficQz60BmNzkIrmZiajs3S7ppw/0\",\"brand_name\":\"test测试店\",\"code_type\":\"CODE_TYPE_ONLY_QRCODE\",\"title\":\"测试的title\",\"color\":\"Color010\",\"notice\":\"使用时向服务员出示此券\",\"service_phone\":\"020-000000\",\"description\":\"不可与其他优惠同享\\n如需团购券发票，请在消费时向商户提出\\n店内均可使用，仅限堂食\",\"date_info\":{\"type\":\"DATE_TYPE_FIX_TIME_RANGE\",\"begin_timestamp\":1544770155,\"end_timestamp\":1545029355},\"sku\":{\"quantity\":50},\"use_limit\":1,\"get_limit\":1,\"use_custom_code\":false,\"bind_openid\":false,\"can_share\":true,\"can_give_friend\":true,\"center_title\":\"顶部居中按钮\",\"center_sub_title\":\"按钮下方的wording\",\"center_url\":\"http://amaayt.natappfree.cc/wx/api/page\",\"custom_url_name\":\"立即使用\",\"custom_url\":\"http://amaayt.natappfree.cc/wx/api/page\",\"custom_url_sub_title\":\"6个汉字tips\",\"promotion_url_name\":\"更多优惠\",\"promotion_url\":\"http://amaayt.natappfree.cc/wx/api/page\",\"source\":\"测试source\"},\"deal_detail\":\"测试的deal_detail\"}}}";
       /* String xxx = "{\"action_name\":\"QR_CARD\",\"expire_seconds\":1800,\"action_info\":{\"card\":{\"card_id\":\"pDHSQ1qy1k_fwVXiHBCiURjq3ESE\",\"is_unique_code\":false,\"outer_str\":\"12b\"}}}";
        String res  = RestfulClient.postJson(CardApi.get_qr,String.class,xxx,WxSubscribeBaseConstant.access_token);
        System.out.println(res);*/

        // 核销  背景 http://mmbiz.qpic.cn/mmbiz_jpg/0KfniaLO2vHwSZ9Syg9ibDaic94ycxfhlfqT8iazUpb3VhL3cibeK5V7yqTvFdT7tNGBlfHQnSvx3pGgLTVmNt63NPg/0
        /*String xxx = "{\"code\":\"934565896170\"}";
        String res  = RestfulClient.postJson(CardApi.USE,String.class,xxx,WxSubscribeBaseConstant.access_token);
        System.out.println(res);*/
        // 创建会员卡
        /*String xxx = "{\"card\":{\"card_type\":\"MEMBER_CARD\",\"member_card\":{\"background_pic_url\":\"http://mmbiz.qpic.cn/mmbiz_jpg/0KfniaLO2vHwSZ9Syg9ibDaic94ycxfhlfqT8iazUpb3VhL3cibeK5V7yqTvFdT7tNGBlfHQnSvx3pGgLTVmNt63NPg/0\",\"base_info\":{\"logo_url\":\"http://mmbiz.qpic.cn/mmbiz_jpg/0KfniaLO2vHwSZ9Syg9ibDaic94ycxfhlfqiczaQJsiaqp6qau1yYC1maJkFEZg5wJvficQz60BmNzkIrmZiajs3S7ppw/0\",\"brand_name\":\"测试brand_name\",\"code_type\":\"CODE_TYPE_TEXT\",\"title\":\"测试title\",\"color\":\"Color010\",\"notice\":\"使用时向服务员出示此券\",\"service_phone\":\"020-88888888\",\"description\":\"不可与其他优惠同享\",\"date_info\":{\"type\":\"DATE_TYPE_PERMANENT\"},\"sku\":{\"quantity\":50},\"get_limit\":1,\"use_custom_code\":false,\"can_give_friend\":false,\"custom_url_name\":\"立即使用\",\"custom_url\":\"http://weixin.qq.com\",\"custom_url_sub_title\":\"6个汉字tips\",\"promotion_url_name\":\"营销入口1\",\"promotion_url\":\"http://amaayt.natappfree.cc/wx/api/page\",\"need_push_on_view\":true},\"supply_bonus\":true,\"supply_balance\":false,\"prerogative\":\"test_prerogative\",\"auto_activate\":true,\"custom_field1\":{\"name_type\":\"FIELD_NAME_TYPE_LEVEL\",\"url\":\"http://www.qq.com\"},\"activate_url\":\"http://amaayt.natappfree.cc/wx/api/page\",\"custom_cell1\":{\"name\":\"使用入口2\",\"tips\":\"激活后显示\",\"url\":\"http://www.xxx.com\"},\"bonus_rule\":{\"cost_money_unit\":100,\"increase_bonus\":1,\"max_increase_bonus\":200,\"init_increase_bonus\":10,\"cost_bonus_unit\":5,\"reduce_money\":100,\"least_money_to_use_bonus\":1000,\"max_reduce_bonus\":50},\"discount\":10}}}";
        String res  = RestfulClient.postJson(CardApi.CREATE,String.class,xxx,WxSubscribeBaseConstant.access_token);
        System.out.println(res);*/
        // 会员卡 pDHSQ1sBumYJXiF-1huYxu0BTSK8 card_id
        // ticket gQEi7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAya3RrU2ctY1FlZ20xNXRMajFzNEYAAgRVaBNcAwQIBwAA
        // http:\/\/weixin.qq.com\/q\/02ktkSg-cQegm15tLj1s4F
        // https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEi7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAya3RrU2ctY1FlZ20xNXRMajFzNEYAAgRVaBNcAwQIBwAA
        // String xxx = "{\"action_name\":\"QR_CARD\",\"expire_seconds\":1800,\"action_info\":{\"card\":{\"card_id\":\"pDHSQ1sBumYJXiF-1huYxu0BTSK8\",\"is_unique_code\":false,\"outer_str\":\"12b\"}}}";
        /*String xxx = "{\"card_id\":\"pDHSQ1sBumYJXiF-1huYxu0BTSK8\",\"member_card\":{\"base_info\":{\"pay_info\":{\"swipe_card\":{\"is_swipe_card\":true}}}}}";
        String res  = RestfulClient.postJson(CardApi.UPDATE,String.class,xxx,WxSubscribeBaseConstant.access_token);
        System.out.println(res);*/


    }

}
