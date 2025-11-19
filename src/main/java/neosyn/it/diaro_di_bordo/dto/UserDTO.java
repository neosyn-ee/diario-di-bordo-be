package neosyn.it.diaro_di_bordo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import neosyn.it.diaro_di_bordo.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Setter(AccessLevel.PACKAGE)
    private Long id;
    private String username;
    private String password;
    private Role role;

    public UserDTO(Long id) {
        this.id = id;
    }
}