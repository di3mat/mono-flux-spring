package it.di3mat.shop.domain.order;

import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ShopOrderRepository extends ReactiveCrudRepository<ShopOrder, UUID> {

  Flux<ShopOrder> findAllByCustomer(String customer);
}
