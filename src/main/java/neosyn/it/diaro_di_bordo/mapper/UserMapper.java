package neosyn.it.diaro_di_bordo.mapper;

import neosyn.it.diaro_di_bordo.dto.UserDTO;
import neosyn.it.diaro_di_bordo.entity.User;
import neosyn.it.diaro_di_bordo.enums.Role;

public class UserMapper {

    public UserDTO toDTO(User userEntity) throws Exception {
        UserDTO userDTO = new UserDTO(userEntity.getId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(null); // do NOT put the password
        userDTO.setRole(Role.valueOf(userEntity.getRole()));
        return userDTO;
    }
}