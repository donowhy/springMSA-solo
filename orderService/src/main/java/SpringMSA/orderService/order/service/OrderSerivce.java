package SpringMSA.orderService.order.service;

import SpringMSA.orderService.order.entity.OrderEntity;
import SpringMSA.orderService.order.service.dto.OrderDto;

import java.util.List;

public interface OrderSerivce {
    OrderDto createOrder(String userId, OrderDto orderDto);
    OrderDto getOrderByOrderId(String orderId);
    List<OrderEntity> getOrdersByUserId (String userId);

}
