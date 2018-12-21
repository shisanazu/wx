package com.test.common.constant;

import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;

public class WxApiConstant {

    public static class BaseApi {
        // 获取access_token
        public static final String GET_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={1}&secret={2}";
        // 获取js token
        public static final String GET_JS_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={1}&type=jsapi";
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
        // 获取文件图片等
        public static final String MULTIPART_GET = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token={1}&media_id={2}";
    }

    public static class MessageSendApi {
        // 发送消息  和发送客服消息有点类似的
        public static final String SEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token={1}";
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
        String xxx = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc0965305e0323c74&redirect_uri=http%3A%2F%2Fr9sfxy.natappfree.cc%2Ftest%2Ffour&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        String var1 = "http://r9sfxy.natappfree.cc/test/four";
        String var2 = URLEncoder.encode(var1);
        System.out.println(var2);
    }

}
