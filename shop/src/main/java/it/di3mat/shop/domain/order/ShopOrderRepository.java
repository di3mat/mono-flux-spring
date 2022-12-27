package it.di3mat.shop.domain.order;

import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ShopOrderRepository extends ReactiveCrudRepository<ShopOrder, UUID> {

}
