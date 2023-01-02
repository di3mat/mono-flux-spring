package it.di3mat.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Configuration
public class FakeCustomerConfig {

  @Bean
  public FakeCustomerService fakeCustomer(){
    return new FakeCustomerService("http://localhost:8081");
  }

  public static ExchangeFilterFunction errorHandler(){
    return ExchangeFilterFunction.ofResponseProcessor(Mono::just);

  }
}
