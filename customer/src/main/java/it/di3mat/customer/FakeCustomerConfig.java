package it.di3mat.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeCustomerConfig {

  @Bean
  public FakeCustomerService fakeCustomer(){
    return new FakeCustomerService("http://localhost:8081");
  }

}
