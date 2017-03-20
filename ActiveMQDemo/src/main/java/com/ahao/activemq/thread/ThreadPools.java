package com.ahao.activemq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
	public static ExecutorService pools = Executors.newCachedThreadPool();
}
