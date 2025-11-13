package neosyn.it.diaro_di_bordo.repository;

import neosyn.it.diaro_di_bordo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

}
