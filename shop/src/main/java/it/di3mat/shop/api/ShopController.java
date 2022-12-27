package it.di3mat.shop.api;

import it.di3mat.shop.domain.order.ShopOrder;
import it.di3mat.shop.domain.order.ShopOrderRepository;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/order")
public class ShopController {

  @Autowired
  ShopOrderRepository shopOrderRepository;

  @PostMapping("/new")
  public Mono<ShopOrder> newOrder() {
    return shopOrderRepository.save(
        ShopOrder.builder().amount(BigDecimal.valueOf(Math.random())).build());
  }

  @GetMapping ("/all")
  public Flux<ShopOrder> getOrders() {
    return shopOrderRepository.findAll();
  }
}
