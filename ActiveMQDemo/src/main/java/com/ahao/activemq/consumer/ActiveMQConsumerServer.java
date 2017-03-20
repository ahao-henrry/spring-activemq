package com.ahao.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.ahao.activemq.thread.PollingThread;
import com.ahao.activemq.thread.ThreadPools;

public class ActiveMQConsumerServer implements MessageListener{
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		String msg = "";
		try {
			msg = textMessage.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		if (null != msg && !"".equals(msg)) {
			PollingThread pollingThread = new PollingThread(msg);
			ThreadPools.pools.submit(pollingThread);
		}
	}

}