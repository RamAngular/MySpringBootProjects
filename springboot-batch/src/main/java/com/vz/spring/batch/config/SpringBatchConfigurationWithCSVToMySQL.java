/**
 * 
 */
package com.vz.spring.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

import com.vz.spring.batch.bean.Person;
import com.vz.spring.batch.item.processor.PersonItemProcessor;
import com.vz.spring.batch.notification.JobCompletionNotificationListener;

/**
 * @author RAMIREDDY
 * @since 2018-June-11
 * {@link} 
 * https://spring.io/guides/gs/batch-processing/
 * https://docs.spring.io/spring-batch/trunk/reference/html/metaDataSchema.html
 * 
 * Description : for that Many database vendors don't support sequences ex mysql .
 *  In these cases, work-arounds are used, such as the following for MySQL:
 */
@Configuration
@EnableBatchProcessing
public class SpringBatchConfigurationWithCSVToMySQL {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;


	@Bean
	public FlatFileItemReader<Person> reader(){
		return new FlatFileItemReaderBuilder<Person>()
				.name("reader")
				.resource(new ClassPathResource("sample-data.csv"))
				.delimited()
				.names(new String [] {"firstName", "lastName"})
				.fieldSetMapper(new FieldSetMapper<Person>() {

					@Override
					public Person mapFieldSet(FieldSet fieldSet) throws BindException {
						Person report = new Person();
						report.setFirstName(fieldSet.readString(0));
						report.setLastName(fieldSet.readString(1));
						return report;
					}
				})
				/*.fieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){
					@Override
					public void setTargetType(Class<? extends Person> type) {
						System.out.println("FlatFileItemReader == "+type.getFields());
						setTargetType(Person.class);
					}
				})*/.build();
	}


	@Bean
	public PersonItemProcessor processor(){
		return new PersonItemProcessor();
	}

	/**
	 * 
	 * @param dataSource
	 * @return
	 * Description : reading the file from the csv file and writing the mysql database
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource){
		System.out.println("batch process datasource : "+dataSource);		
		return new JdbcBatchItemWriterBuilder()
		.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider())
		.sql("INSERT INTO springbatchdb.people (first_name, last_name) VALUES (:firstName, :lastName)")
		.dataSource(dataSource)
		.build();
	}


	/**
	 * The first method defines the job and the second one defines a single step. Jobs are built from steps, where each step can involve a reader, a processor, and a writer.
	    In this job definition, you need an incrementer because jobs use a database to maintain execution state. You then list each step, of which this job has only one step. The job ends, and the Java API produces a perfectly configured job.
	    In the step definition, you define how much data to write at a time. In this case, it writes up to ten records at a time. Next, you configure the reader, processor, and writer using the injected bits from earlier.
	 */
	@Bean
	public Job job(JobCompletionNotificationListener listener, Step step){
		return jobBuilderFactory.get("job")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step)
				.end()
				.build();
		/**
		 * job uses batch_job_instance table
		 */
	}

	@Bean
	public Step step(JdbcBatchItemWriter<Person> writer){
		return this.stepBuilderFactory.get("step")
				.<Person, Person> chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer)
				.build();
		/**
		 * The BATCH_STEP_EXECUTION table holds all information relevant to the StepExecution object. 
		 * This table is very similar in many ways to the BATCH_JOB_EXECUTION table 
		 * and there will always be at least one entry per Step for each JobExecution created:
		 */
	}

	/**
	 * batch_job_execution table ensure that about the batch process .
	 * i.e batch start_time , end time and status etc...
	 */
}
