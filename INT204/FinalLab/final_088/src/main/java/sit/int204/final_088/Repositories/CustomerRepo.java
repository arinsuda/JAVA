package sit.int204.final_088.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.final_088.Entities.Customers;

public interface CustomerRepo extends JpaRepository<Customers, Integer> {
}
