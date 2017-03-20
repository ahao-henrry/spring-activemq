package com.ahao.activemq.producer;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/MQ/")
public class ProducerTest {
	@Autowired
	@Qualifier("sendqueueName")
	Destination sendqueueName;
	@Resource
	private ActiveMQProducer activeMQ ;
	
	@ResponseBody
	@RequestMapping("ProducerTest")
	public JSONObject producerTest() {
		JSONObject jsonObject = new JSONObject();
		long startTime = (new Date()).getTime();
		for (int i = 0; i < 100; i++) {
			jsonObject.put("name", "ahao" + i);
			jsonObject.put("age", "18");
			jsonObject.put("sex", "male");
			
			try {
				activeMQ.sendMessage(sendqueueName, jsonObject.toJSONString());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		long endTime = (new Date()).getTime();
		System.out.println("--****Send messages Spend Time is : " + (endTime - startTime));
		return jsonObject;
	}
}
