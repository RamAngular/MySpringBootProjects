/**
 * 
 */
package com.vz.spring.batch.item.processor;

import org.springframework.batch.item.ItemProcessor;

import com.vz.spring.batch.bean.Person;

/**
 * @author RAMIREDDY
 * @since 2018-June-11
 * {@link} https://spring.io/guides/gs/batch-processing/
 * Description : 
 * Create an intermediate processor
 *  A common paradigm in batch processing is to ingest data, transform it, and then pipe it out somewhere else. 
*   Here you write a simple transformer that converts the names to uppercase.
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person person) throws Exception {

		String firstName = person.getFirstName().toUpperCase();
		String lastName = person.getLastName().toUpperCase();
		
		return new Person(firstName, lastName);
	}

}
