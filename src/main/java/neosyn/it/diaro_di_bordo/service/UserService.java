package neosyn.it.diaro_di_bordo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neosyn.it.diaro_di_bordo.dto.UserDTO;
import neosyn.it.diaro_di_bordo.entity.User;
import neosyn.it.diaro_di_bordo.mapper.UserMapper;
import neosyn.it.diaro_di_bordo.repository.UserRepository;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    private final java.util.Map<Long, UserDTO> userCache = new java.util.HashMap<>();

    public UserService() {
        /*
         * UserDTO mockUser1 = new UserDTO(123456789L, "John Doe",
         * "the most secure password in the world", null);
         * UserDTO mockUser2 = new UserDTO(987654321L, "Jane Doe",
         * "another super secure password", null);
         * userCache.put(mockUser1.getId(), mockUser1);
         * userCache.put(mockUser2.getId(), mockUser2);
         */
    }

    public UserDTO getUserByID(Long id) {
        Optional<User> userFound = userRepo.findById(id);
        if (userFound.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        try {
            return userMapper.toDTO(userFound.get());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Cant map from Entoty to DTO", e);
            return null;
        }
    }
}
