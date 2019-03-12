package com.vz.spring.batch.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * @author RAMIREDDY
 * @since 2018-June-12
 */
@RestController
@RequestMapping("/batch")
@Api(value = "Spring Batch Job Invokke controller")
public  class JobInvokeController {

	@Autowired
	private	JobLauncher jobLauncher;
	@Autowired(required = true)
	private	Job job;

	@GetMapping("/invokejob")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> handle(){

		System.out.println("handle ==>>>>>> invoked");
		JobParameters jobParameters = new JobParametersBuilder()
		.addLong("time", System.currentTimeMillis())
		.toJobParameters();

		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			e.printStackTrace();
		} catch (JobRestartException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}

		return  ResponseEntity.ok("Batch job has been invoked and completed");
	}

	@GetMapping("/hello")
	@Produces(MediaType.APPLICATION_JSON)
	public String hello() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
		//the second parameter of jobLauncher uses batch_job_execution_params table
		jobLauncher.run(job, new JobParametersBuilder().addLong("Time", System.currentTimeMillis()).toJobParameters());
		return "Hello Spring Boot Batch Job";
	}

}
