package it.di3mat.customer.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeCustomerConfig {

  @Bean
  public FakeCustomer fakeCustomer(){
    return new FakeCustomer("http://localhost:8081");
  }

}
