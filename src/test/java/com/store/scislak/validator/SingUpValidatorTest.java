package com.store.scislak.validator;

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

import com.store.scislak.dataBase.impl.ReadClient;
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
}
