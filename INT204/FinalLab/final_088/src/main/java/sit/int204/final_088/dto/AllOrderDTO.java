package sit.int204.final_088.dto;

import lombok.Getter;
import lombok.Setter;
import sit.int204.final_088.Entities.Customers;

import java.sql.Timestamp;

@Getter
@Setter
public class AllOrderDTO {
    private Integer id;
    private String orderNumber;
    private Timestamp orderDate;
    private double totalAmount;
}
