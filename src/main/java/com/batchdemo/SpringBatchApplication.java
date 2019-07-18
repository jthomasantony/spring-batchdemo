package com.batchdemo;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
    exclude = {DataSourceAutoConfiguration.class})
public class SpringBatchApplication implements ApplicationRunner{

  public static void main(String[] args) {
    SpringApplication.run(SpringBatchApplication.class, args);
  }
  
  @Override
  public void run(ApplicationArguments args) throws Exception {
	  System.out.println("command line arguments: "+Arrays.toString(args.getSourceArgs()));
	  
	  for(String name: args.getOptionNames()) {
		  System.out.println("argument- "+ name + " = "+args.getOptionValues(name));
	  }
	  
	  boolean containsOption = args.containsOption("file.location");
	  System.out.println("Contains file.location "+containsOption);
  }
  
}
