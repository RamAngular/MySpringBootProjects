package com.vz.spring.batch.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vz.spring.batch.bean.Person;

/**
 * 
 * @author RAMIREDDY
 * @since 2018-June-11
 *This code listens for when a job is BatchStatus.COMPLETED, 
 *and then uses JdbcTemplate to inspect the results.
 */
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*public JobCompletionNotificationListener(){

	}*/

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("BatchJob has been invoked");
	}


	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED){
			log.info("!!! JOB FINISHED! Time to verify the results");
        
			this.jdbcTemplate.query("SELECT first_name, last_name FROM people", 
					(rs, row) -> new Person(
							rs.getString(1),
							rs.getString(2)
							)
					).forEach(person -> log.info("Found <" + person + "> in the database."));
		
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}
}
