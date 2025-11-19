package neosyn.it.diaro_di_bordo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.AccessLevel;
//import lombok.Setter;

import neosyn.it.diaro_di_bordo.model.enums.Roles;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // @Setter(AccessLevel.PROTECTED) // removed due to issues in initialization,
    // left for "teaching"
    private Long id;
    private String username;
    private String password;
    private Roles role;

    public UserDTO(Long id) {
        this.id = id;
    }
}
