package wesley.io.restful.api.java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wesley.io.restful.api.java.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByAccountAccountNumber(String accountNumber);
}
