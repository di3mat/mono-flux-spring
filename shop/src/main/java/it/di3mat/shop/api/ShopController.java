package it.di3mat.shop.api;

import it.di3mat.shop.domain.order.ShopOrder;
import it.di3mat.shop.domain.order.ShopOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
  ShopOrderService shopOrderService;

  @PostMapping("/new")
  public Mono<ShopOrder> newOrder(Authentication authentication) {
    return shopOrderService.createNewShopOrder(authentication.getName());
  }

  @GetMapping ("/all")
  public Flux<ShopOrder> getOrders(Authentication authentication) {
    return shopOrderService.getAllShopOrderByCustomer(authentication.getName());
  }
}
