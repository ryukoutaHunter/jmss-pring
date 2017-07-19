package com.queueing.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name = "topicDestination")
    Destination destination;
    public void sendMessage(final String message) {
        //使用JmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            //创建消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("Recevied Message:"+message);

    }
}
