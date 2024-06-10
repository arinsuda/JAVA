package sit.int204.final_088.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.final_088.Entities.Orders;
import sit.int204.final_088.Services.OrdersService;
import sit.int204.final_088.dto.AllOrderDTO;
import sit.int204.final_088.dto.OrderDTO;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrdersService orderService;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("")
    public List<Orders> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Integer id){
        Orders orders = orderService.findById(id);
        OrderDTO dto = modelMapper.map(orders, OrderDTO.class);
        return ResponseEntity.ok(dto);
    }

}
