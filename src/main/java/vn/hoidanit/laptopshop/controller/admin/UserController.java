package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.entity.User;

import vn.hoidanit.laptopshop.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    // private final UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    // @RequestMapping("/")
    // public String getHomePage(Model model) {
    // // tra ve view (static: file tĩnh)
    // String test = this.userService.handleHomePage();
    // // eric : tên biến trong view
    // // test: giá trị của biến
    // model.addAttribute("eric", test);
    // return "hello";
    // }

    @GetMapping("/admin/user")
    public String getIndex(Model model) {
        List<User> users = this.userService.handleGetAllUser();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/{id}")
    public String getDetail(@PathVariable long id, Model model) {
        Optional<User> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getUpdate(@PathVariable long id, Model model) {
        Optional<User> user = this.userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("newUser", user.get());
        }
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    // phai map voi ten modelatreibute ben view
    public String getUpdate(Model model, @ModelAttribute User newUser) {
        Optional<User> user = this.userService.getUserById(newUser.getId());
        if (user.isPresent()) {
            User u = user.get();
            u.setAddress(newUser.getAddress());
            u.setPhone(newUser.getPhone());
            this.userService.handleSaveUser(u);
        }
        return "redirect:/admin/user";
    }

    // GET
    // return String :
    @RequestMapping("/admin/user/create")
    public String getCreate(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // POST
    @RequestMapping(value = "/admin/user/created", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute("newUser") User newuser, BindingResult result) {
        this.userService.handleSaveUser(newuser);
        return "hello";
    }

}
