package sit.int204.final_088.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.final_088.Entities.Orders;
import sit.int204.final_088.Exception.ItemNotFoundException;
import sit.int204.final_088.Repositories.OrderRepo;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    public OrderRepo orderRepo;

    @Autowired
    public ModelMapper modelMapper;

    public Orders findById(Integer id) {
        return orderRepo.findById(id).orElseThrow(
                () -> new ItemNotFoundException("OrderId is not found!")
        );
    }

    public List<Orders> getAllOrder() {
        return orderRepo.findAll();
    }
}
