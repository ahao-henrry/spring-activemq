package com.ahao.activemq.thread;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

public class PollingThread implements Callable<JSONObject> {
	private Logger logger = Logger.getLogger(PollingThread.class);
	
	private String data;
	public PollingThread(String data) {
		this.data = data;
	}

	@Override
	public JSONObject call() throws Exception {
		printData(data);
		return null;
	}
	
	private void printData(String msg) {
		logger.info("--****The pre threadData is : " + msg);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("--****The next threadData is : " + msg);
	}
}
