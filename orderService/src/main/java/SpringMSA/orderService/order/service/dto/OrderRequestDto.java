package SpringMSA.orderService.order.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDto implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private String userId;
}
