package sit.int204.final_088.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {
    @Id
    private Integer id;

    @Column(name = "productName", length = 50)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "id", insertable=false, updatable=false)
    private Suppliers supplier;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "package", length = 30)
    private String packageFeild;

    @Column(name = "discontinued")
    private boolean isDiscontinued;


}
