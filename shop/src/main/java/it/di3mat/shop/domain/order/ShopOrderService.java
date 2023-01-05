package it.di3mat.shop.domain.order;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ShopOrderService {

  final String LOG_TAG = this.getClass().getSimpleName();

  @Autowired ShopOrderRepository repository;

  public Mono<ShopOrder> createNewShopOrder(String customer){
    return repository.save(
            ShopOrder.builder().customer(customer).amount(BigDecimal.valueOf(Math.random())).build())
        .doOnSuccess(shopOrder -> log.info("[{}] Customer: {}. Created new order {}", LOG_TAG, shopOrder.getCustomer(),
            shopOrder.getId()));
  }

  public Flux<ShopOrder> getAllShopOrderByCustomer(String customer) {
    return repository.findAllByCustomer(customer);
  }
}
