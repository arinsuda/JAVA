package sit.int204.final_088.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    private Integer id;

    @Column(name = "orderDate", nullable = false,insertable = false,updatable = false)
    private Timestamp orderDate;

    @Column(name = "orderNumber", length = 10)
    private String orderNumber;

    @JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name = "id", referencedColumnName = "id" ,insertable = false,updatable = false)
    private Customers customerId;

    @Column(name = "totalAmount")
    private double totalAmount;

    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private Set<OrderItems> orderItems;

}
