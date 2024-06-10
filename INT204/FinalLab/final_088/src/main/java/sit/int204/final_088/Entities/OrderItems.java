package sit.int204.final_088.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName="id", insertable=false, updatable=false)
    private Orders orderId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName="id", insertable=false, updatable=false)
    private Products productId;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;

}
