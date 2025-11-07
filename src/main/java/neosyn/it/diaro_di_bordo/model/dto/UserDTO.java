package neosyn.it.diaro_di_bordo.model.dto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Setter(AccessLevel.PACKAGE)
    private Long id;
    private String username;
    private String password;
    private Object role;
}