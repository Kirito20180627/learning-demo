package com.ldy.design_pattern.observer;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailSendService implements SendMsgService {

    @Override
    public void sendMsg(String content) {
        System.out.println("邮件发送：" + content);

    }
}
