package it.di3mat.customer;

import it.di3mat.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class FakeCustomerService {

  private final String LOG_TAG = this.getClass().getSimpleName();
  WebClient webClient;

  public FakeCustomerService(String baseUrl) {
    this.webClient = WebClient.builder().baseUrl(baseUrl).build();
  }

  @Scheduled(fixedRate = 5000L)
  public void sendOrders() {
    this.webClient.post()
        .uri(uriBuilder -> uriBuilder.path("/order/new").build())
        .retrieve()
        .bodyToMono(OrderResponse.class)
        .doOnError(error -> log.error("[{}] Order not received: {}", LOG_TAG, error.getMessage()))
        .subscribe(invoice -> log.info("[{}] Order received: id {} with amount {}",
            LOG_TAG,
            invoice.getId(),
            invoice.getAmount()));
  }

}
