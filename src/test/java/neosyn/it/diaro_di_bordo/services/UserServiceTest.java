package neosyn.it.diaro_di_bordo.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserByIDTest() {

        // Mocks
        long mockUserId = 123456789L;

        UserEntity mockEntity = new UserEntity();
        mockEntity.setId(mockUserId);
        mockEntity.setUsername("John Doe");
        mockEntity.setPassword("the most secure password in the world");
        mockEntity.setRole(null);

        // Simula il comportamento del repository
        when(userRepository.findById(mockUserId)).thenReturn(Optional.of(mockEntity));

        UserDTO mockUser = new UserDTO();
        mockUser.setId(mockUserId);
        mockUser.setUsername("John Doe");
        mockUser.setPassword("the most secure password in the world");
        mockUser.setRole(null);

        UserDTO expected = mockUser;

        UserDTO returned = userService.getUserByID(mockUserId);

        // Assert
        assertEquals(mockUser, returned);
    }
}