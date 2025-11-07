package neosyn.it.diaro_di_bordo.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neosyn.it.diaro_di_bordo.model.dto.UserDTO;
// import neosyn.it.diaro_di_bordo.model.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    // @Autowired private UserRepository userRepo;

    // @Autowired
    // private UserMapper userMapper;

    private final Map<Long, UserDTO> userCache = new HashMap<>();

    public UserService() {
        UserDTO mockUser1 = new UserDTO(123456789L, "John Doe", "the most secure password in the world", null);
        UserDTO mockUser2 = new UserDTO(987654321L, "Jane Doe", "another super secure password", null);

        userCache.put(mockUser1.getId(), mockUser1);
        userCache.put(mockUser2.getId(), mockUser2);
    }

    public UserDTO getUserByID(Long id) {
        // return userMapper.toDTO(userRepo.findUserByID(id));

        return userCache.get(id);
    }
}
