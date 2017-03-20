package com.ahao.activemq.producer;

import javax.jms.Destination;
import javax.jms.JMSException;

public interface ActiveMQProducer {

	void sendMessage(Destination destination, String message)
			throws JMSException;

}
