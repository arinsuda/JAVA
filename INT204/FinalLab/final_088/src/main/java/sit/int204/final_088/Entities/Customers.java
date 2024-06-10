package sit.int204.final_088.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.query.Order;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @NotNull
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 40)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 40)
    private String lastName;

    @Column(name = "city", nullable = false, length = 40)
    private String city;

    @Column(name = "country", nullable = false, length = 40)
    private String country;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "id")
    private Set<Orders> oreders;

}
