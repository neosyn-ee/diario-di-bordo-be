package neosyn.it.diaro_di_bordo.repository;

import neosyn.it.diaro_di_bordo.model.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Long> {
    public UserDTO findByUsername(String username);

}
