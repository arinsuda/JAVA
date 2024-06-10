package sit.int204.final_088.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @Column(name = "id", insertable=false, updatable=false)
    private Integer supplierId;

    @Column(name = "companyName", length = 40)
    private String companyName;

    @Column(name = "contactName", length = 50)
    private String contactName;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 40)
    private String country;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "fax", length = 30)
    private String fax;

    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private Set<Products> products;
}
