package neosyn.it.diaro_di_bordo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neosyn.it.diaro_di_bordo.model.dto.UserDTO;
import neosyn.it.diaro_di_bordo.model.mapper.UserMapper;

@Service
public class UserService {

    // @Autowired private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserByID(Long id) {
        // return userMapper.toDTO(userRepo.findUserByID(id));

        // TODO: in teora, questo utente dovrebbe essere recuperato dalla repository
        UserDTO user = new UserDTO(id, "", "", null);
        user.setUsername("Mocked Name");
        user.setPassword("the most secure password in the world");
        user.setRole(null);
        return user;
    }
}
