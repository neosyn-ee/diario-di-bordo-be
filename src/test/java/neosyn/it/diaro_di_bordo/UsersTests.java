package neosyn.it.diaro_di_bordo;

import neosyn.it.diaro_di_bordo.entity.User;
import neosyn.it.diaro_di_bordo.repository.UserRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@DataJpaTest
class UsersTests {

    private static final Logger logger = LogManager.getLogger(DiaroDiBordoApplicationTests.class);
    private User user;
    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void setUp() {
        user = new User(1L, "admin", "secret", "ROLE_ADMIN");
        logger.info("Inizializzazione User per i test");
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        logger.info("Verifica costruttore e getter");
        assertEquals(1L, user.getId());
        assertEquals("admin", user.getUsername());
        assertEquals("secret", user.getPassword());
        assertEquals("ROLE_ADMIN", user.getRole());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        logger.info("Verifica costruttore vuoto e setter");
        User u = new User();
        u.setUsername("user");
        u.setPassword("pwd");
        u.setRole("ROLE_USER");
        assertEquals("user", u.getUsername());
        assertEquals("pwd", u.getPassword());
        assertEquals("ROLE_USER", u.getRole());
    }

    @Test
    void testEqualsAndHashCode() {
        logger.info("Verifica equals() e hashCode()");
        User u1 = new User(2L, "john", "123", "ROLE_USER");
        User u2 = new User(2L, "john", "123", "ROLE_USER");
        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void testToString() {
        logger.info("Verifica metodo toString()");
        String result = user.toString();
        assertTrue(result.contains("admin"));
        assertTrue(result.contains("secret"));
        assertTrue(result.contains("ROLE_ADMIN"));
    }

    @Test
    void testMockitoMockBehavior() {
        logger.info("Verifica mock con Mockito");
        User mockUser = Mockito.mock(User.class);
        Mockito.when(mockUser.getUsername()).thenReturn("mockedUser");
        assertEquals("mockedUser", mockUser.getUsername());
        Mockito.verify(mockUser, Mockito.times(1)).getUsername();
    }

    @Test
    void testSaveAndFindByUsername() {
        logger.info("Verifica salvataggio e recupero utente per username");
        User user = new User(null, "mario", "pwd123", "ROLE_USER");
        userRepository.save(user);
        Optional<User> found = Optional.ofNullable(userRepository.findByUsername("mario"));
        assertThat(found).isPresent();
        assertThat(found.get().getUsername()).isEqualTo("mario");
        assertThat(found.get().getRole()).isEqualTo("ROLE_USER");
    }
    @Test
    void testFindByUsernameNotFound() {
        logger.info("Verifica che findByUsername restituisca vuoto per utente inesistente");
        Optional<User> found = Optional.ofNullable(userRepository.findByUsername("ghost"));
        assertThat(found).isNotPresent();
    }
}
