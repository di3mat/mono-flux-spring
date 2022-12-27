package it.di3mat.shop.api;

import it.di3mat.shop.domain.order.ShopOrder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/order")
public class ShopController {

  final String LOG_TAG = this.getClass().getSimpleName();

  @PostMapping("/new")
  public Mono<ShopOrder> newOrder() {
    return Mono.create(
        monoSink -> {
          var newOrder = ShopOrder.builder().id(UUID.randomUUID()).amount(BigDecimal.valueOf(100L).divide(
                      BigDecimal.valueOf(Math.random()), RoundingMode.HALF_UP))
                  .build();
          log.info("[{}] New order received. Id: {}, amount: {}", LOG_TAG,newOrder.getId(),
              newOrder.getAmount());
          monoSink.success(newOrder);
        });
  }
}
