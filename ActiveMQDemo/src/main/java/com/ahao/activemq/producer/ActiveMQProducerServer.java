package com.ahao.activemq.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQProducerServer implements ActiveMQProducer{
	@Resource
	private JmsTemplate jmsTemplate;
	
    @Override
    public void sendMessage(Destination destination, final String message) throws JMSException{ 
        jmsTemplate.send(destination, new MessageCreator() {  
            public Message createMessage(Session session) throws JMSException {  
                return session.createTextMessage(message);  
            }  
        });  
    }   
 
}
