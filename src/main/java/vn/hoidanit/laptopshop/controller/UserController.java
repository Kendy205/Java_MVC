package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.entity.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.services.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    // private final UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        // tra ve view (static: file tĩnh)
        String test = this.userService.handleHomePage();
        // eric : tên biến trong view
        // test: giá trị của biến
        model.addAttribute("eric", test);
        return "hello";
    }

    // GET
    // return String :
    @RequestMapping("admin/user/create")
    public String getCreate(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // POST
    @RequestMapping(value = "admin/user/create1", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("newUser") User newuser, BindingResult result) {
        this.userService.handleSaveUser(newuser);
        return "hello";
    }

    @RequestMapping(value = "admin/user", method = RequestMethod.GET)
    public String GetAllUser() {
        List<User> users = this.userService.handleGetAllUser();
        return "hello";
    }

}
