package com.qf.oa.utli;

import com.qf.oa.entity.Employee;
import io.rong.RongCloud;
import io.rong.messages.TxtMessage;
import io.rong.methods.message._private.Private;
import io.rong.methods.user.User;
import io.rong.models.message.PrivateMessage;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

public class TokenUtil {
    private static final   String appKey = "qf3d5gbjqhruh";
    private static final   String appSecret = "xQbvnQb9uhwI";
    private static RongCloud rongCloud;
    static {
        rongCloud = RongCloud.getInstance(appKey, appSecret);
    }
    public static String getToken(Employee employee){
        User User = rongCloud.user;

        /**
         * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
         *
         * 注册用户，生成用户在融云的唯一身份标识 Token
         */
        UserModel user = new UserModel()
                .setId(employee.getId()+"")
                .setName(employee.getName())
                .setPortrait("http://www.rongcloud.cn/images/logo.png");
             TokenResult result = null;
            try {
                result = User.register(user);
            } catch (Exception e) {
                return null;
            }
                return result.getToken();
    }

    public static void sendmsg(String fromId, String content, String...toid){
        Private msgPrivate=rongCloud.message.msgPrivate;
        TxtMessage txtMessage=new TxtMessage(content,null);

        PrivateMessage privateMessage=new PrivateMessage();
        privateMessage.setContent(txtMessage);
        privateMessage.setSenderId(fromId);
        privateMessage.setTargetId(toid);
        privateMessage.setObjectName(txtMessage.getType());
        try {
            msgPrivate.send(privateMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
