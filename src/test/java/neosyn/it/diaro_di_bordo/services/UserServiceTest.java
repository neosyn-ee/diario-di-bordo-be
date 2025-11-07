package neosyn.it.diaro_di_bordo.services;
import neosyn.it.diaro_di_bordo.model.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByIDTest() {

        // Mocks
        long mockUserId = 123456789L;

        UserDTO expectedUser = new UserDTO(mockUserId, "John Doe", "the most secure password in the world", null);

        UserDTO returned = userService.getUserByID(mockUserId);

        // Assert
        assertEquals(expectedUser, returned);
    }
}