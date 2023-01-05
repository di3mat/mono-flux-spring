package it.di3mat.shop.domain.order;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrder {

  @Id
  UUID id;
  BigDecimal amount;

  String customer;

}
