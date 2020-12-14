package com.akash;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleExample {
	
	// Components of Quartz
	// 1. Job - task
	// 2. Trigger -
	//            1. SimpleTrigger
	//            2. CronTrigger
	// 3. Scheduler	
	
	// The key interfaces of the API are:
	
	// 		Scheduler – the primary API for interacting with the scheduler of the framework
	// 		Job – an interface to be implemented by components that we wish to have executed
	// 		JobDetail – used to define instances of Jobs
	// 		Trigger – a component that determines the schedule upon which a given Job will be performed
	// 		JobBuilder – used to build JobDetail instances, which define instances of Jobs
	// 		TriggerBuilder – used to build Trigger instances

	public static void main(String[] args) {
		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Scheduler sched = sf.getScheduler();
			
			JobDetail job = JobBuilder.newJob(SimpleJob.class)
					.withIdentity("myJob")
					.build();
			
			/*Trigger simpleTrigger = TriggerBuilder.newTrigger()
					.withIdentity("simpleTrigger")
					.startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(5)
							.repeatForever())
					.build();*/
			
			// CRON Expression: * * * * * *
			//                  sec min h dayOfMon month dayOfWeek year(optional)
			Trigger cronTrigger = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
					.build();
			
			sched.start();
			sched.scheduleJob(job, cronTrigger);
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
