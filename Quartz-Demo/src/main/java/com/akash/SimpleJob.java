package com.akash;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("This is a quartz job!");
		
		for(int i = 0; i < 5; i++) {
			System.out.println("i = " + i);
		}
	}

}
