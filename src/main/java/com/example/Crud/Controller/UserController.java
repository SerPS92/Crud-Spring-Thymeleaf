package com.example.Crud.Controller;

import com.example.Crud.Model.User;
import com.example.Crud.Service.IUserService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id")Integer id,
                       Model model){
        Optional<User> optionalUser = userService.findById(id);
        User user = new User();
        user = optionalUser.get();
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Integer id){
        userService.deleteById(id);
        return "redirect:/";
    }
}
