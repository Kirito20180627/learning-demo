package com.ldy.design_pattern.observer;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsSendService implements SendMsgService {

    @Override
    public void sendMsg(String content) {
        System.out.println("短信发送：" + content);
    }
}
