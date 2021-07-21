package com.lugonzo.jsm.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lugonzo.jsm.config.JmsConfig;
import com.lugonzo.jsm.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hey Abuu001 !! How are you ??")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE,message);
    }

    @Scheduled(fixedRate = 2000)
    public void  sendAndReceiveMessage() throws JMSException {
        System.out.println("######    I am Sending Message   ######");
        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hey Abuu001 !! How are you ??")
                .build();

         Message receivedMessage= jmsTemplate.sendAndReceive(JmsConfig.MY_QUEUE,  new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message helloMessage = null;

                try {
                    helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
                    helloMessage.setStringProperty("_type", "com.lugonzo.jsm.model.HelloWorldMessage");
                    System.out.println("Sending hello");

                    return helloMessage;
                } catch (JsonProcessingException e) {
                    throw new JMSException("boom");
                }

            }
        });

        System.out.println(receivedMessage.getBody(String.class));
    }
}
