package SpringMSA.orderService.order.controller;

import SpringMSA.orderService.order.service.OrderSerivce;
import SpringMSA.orderService.order.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderSerivce orderSerivce;

    @PostMapping("/{userId}/orders")
    public OrderDto createOrder(@PathVariable("userId") String userId,  OrderDto orderDto) {
        return orderSerivce.createOrder(userId, orderDto);
    }
}
