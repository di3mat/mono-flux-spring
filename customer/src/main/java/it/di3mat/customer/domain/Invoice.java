package it.di3mat.customer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

  @NotNull
  Order order;
  Date date;

  public UUID getId() {
    return this.getOrder().getId();
  }

  public BigDecimal getAmount() {
    return this.getOrder().getAmount();
  }
}
