package com.javainuse.taskconfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 
 * @author RAMIREDDY
 * {@link https://howtodoinjava.com/spring-boot/enable-scheduling-scheduled-job-example/ }
 */
@Component
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	/**
	 * fixedRate  does not wait for the completion of previous execution.
	 */
	@Scheduled(fixedRate = 10000)
	public void performTask() {
		System.out.println("Regular task performed at :: "+ dateFormat.format(new Date()));
	}
	/**
	 * fixedDelay is scheduling task with delay in milliseconds.
	 */
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void performDelayedTask() {
		System.out.println("Delayed Regular task performed at :: "	+ dateFormat.format(new Date()));
	}

	/**
	 * Sometimes delays and rates are not enough, 
	 * and we need the flexibility of a cron expression to control the schedule of our tasks:
	 */
	/**
	 * {@link} http://www.baeldung.com/spring-scheduled-tasks
	 */
	@Scheduled(cron = "*/5 * * * * *")
	public void performTaskUsingCron() {
		System.out.println("Regular task performed using Cron at :: "+ dateFormat.format(new Date()));
	}

	//@Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")
	@Scheduled(cron = "0 15 10 15 * ?") //that we’re scheduling a task to be executed at 10:15 AM on the 15th day of every month.
	//@Scheduled(cron = "0 0 12 * * ?") //Fires at 12 PM every day:
	//@Scheduled(cron = "0 15 10 * * ? 2005") //ires at 10:15 AM every day in the year 2005:
	//@Scheduled(cron = "0/20 * * * * ?")//Fires every 20 seconds:
	//cron expression allowas 5 stars and one ? is mandatory after this it allows one more so far as i know.
	public void scheduleTaskUsingCronExpression() {
		long now = System.currentTimeMillis() / 1000;
		System.out.println("schedule tasks using cron jobs - " + now);
	}
}
