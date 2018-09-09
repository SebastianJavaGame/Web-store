package com.store.scislak.validator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.store.scislak.dataBase.ReadableDataBase;
import com.store.scislak.encje.Client;

@ContextConfiguration("test-servlet-context.xml")
@WebAppConfiguration
public class SingUpValidatorTest {
	
	public static Validator validator;
	
	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void simpleValidation() {
		Client client = new Client(null, "Scislak", "sosnówka 27", "08-550", "sebek2088s4@tlen.pl");
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		Assert.assertEquals(violations.size(), 1);
		
		ConstraintViolation<Client> violation = violations.iterator().next();
		Assert.assertEquals(violation.getMessage(), "{NotEmpty.Client.name.validation}");
	}
	
	@Test
	public void allErrorsOfValidation() {
		Client client = new Client(null, "", "", null, "sebek2088s4tlen.pl");
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		Assert.assertEquals(violations.size(), 5);
	}
	
	@Test
	public void readClientWithDBUsingMockito() {
		ReadableDataBase readableDataBase = mock(ReadableDataBase.class);
		Client client = new Client("Sebastian", "Nazwisko", "Adres", "08-550", "scislak2088s4@tlen.pl");
		List<Client> list = new ArrayList<Client>();
		list.add(client);
		//when(readableDataBase.read("Client")).thenReturn((List<?>) list);
		
		assertEquals(client, readableDataBase.readAll("Client").get(0));
	}
}
