package sit.int204.final_088.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sit.int204.final_088.Entities.Customers;
import sit.int204.final_088.Entities.OrderItems;

import java.sql.Timestamp;
import java.util.List;

@Data
@Getter
@Setter
public class OrderDTO {
    private Integer id;
    private String orderNumber;
    private Timestamp orderDate;
    private Customers customer;
    private double totalAmount;
    private List<OrderItems> orderItems;

}
