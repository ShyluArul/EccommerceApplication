package com.test.product1;

import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpRequest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.test.provider1.EcommerceApplication;
import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;
import com.test.provider1.service.EcommerceService;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.TargetRequestFilter;
import au.com.dius.pact.provider.junit.VerificationReports;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@PactFolder("C:\\Users\\dell\\shylunew\\New-Pact-master\\consumer1\\target\\pacts")

@Provider("EcommereceProvider")
@VerificationReports(value = { "console", "markdown", "json" })

public class Product1Test {

	private int PORT = 9080;

	@TestTarget

	public final Target target = new HttpTarget("http", "localhost", PORT);

	private static ConfigurableApplicationContext applicationContext;

	@BeforeClass

	public static void start() {

		applicationContext = SpringApplication.run(EcommerceApplication.class);

	}

	

	@AfterClass

	public static void stop() {

		SpringApplication.exit(applicationContext);

	}

	
	@State("DELL")

	public void withSomeState() {

		System.out.println("get list of products from DELL");
		
		EcommerceService ecommerceService = applicationContext.getBean(EcommerceService.class);
		ecommerceService.addManufacturer( new ManufacturerPO("5680","DELL","Chennai",null ));
		ecommerceService.addProduct( new ProductsPO("1010","DELL Inspiron","Laptop",82000.0,"5680"));
		
	}
	@State("1011")

	public void withSomeState1() {

		System.out.println("get list of products by productid 1011");
		
		EcommerceService ecommerceService = applicationContext.getBean(EcommerceService.class);
		ecommerceService.addManufacturer( new ManufacturerPO("5681","Lenova","Hyderabad",null ));
		ecommerceService.addProduct( new ProductsPO("1011","HP Zbook","Laptop",65000.0,"5681"));
		
	}
	
	
	
	
	
}
