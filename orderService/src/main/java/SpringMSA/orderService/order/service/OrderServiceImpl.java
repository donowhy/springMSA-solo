package SpringMSA.orderService.order.service;

import SpringMSA.orderService.order.entity.OrderEntity;
import SpringMSA.orderService.order.repository.OrderRepository;
import SpringMSA.orderService.order.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderSerivce {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(String userId, OrderDto orderDto) {
        OrderEntity build = OrderEntity.builder()
                            .orderId(UUID.randomUUID().toString())
                            .userId(userId)
                            .totalPrice(orderDto.getQty() * orderDto.getUnitPrice())
                            .build();

        orderRepository.save(build);

        return orderDto;
    }

    @Override
    public OrderDto getOrderByOrderId(String orderId) {
        OrderEntity byOrderId = orderRepository.findByOrderId(orderId);
        return OrderDto.builder()
                .orderId(byOrderId.getOrderId())
                .totalPrice(byOrderId.getTotalPrice())
                .build();
    }

    @Override
    public List<OrderEntity> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

}
