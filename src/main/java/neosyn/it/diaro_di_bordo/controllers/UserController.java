package neosyn.it.diaro_di_bordo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;
import neosyn.it.diaro_di_bordo.dto.UserDTO;
import neosyn.it.diaro_di_bordo.service.UserService;

@Controller("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(
            @RequestBody String email, @RequestBody String password) {
        return "NO LOGIN IMPLEMENTED YET";
    }

    @GetMapping("/{id}")
    public UserDTO getUserByID(@PathVariable("id") String id) {
        return userService.getUserByID(Long.parseLong(id));
    }

}
