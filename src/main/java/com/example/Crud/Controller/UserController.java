package com.example.Crud.Controller;

import com.example.Crud.Model.User;
import com.example.Crud.Service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String home(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
