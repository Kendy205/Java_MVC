package vn.hoidanit.laptopshop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.hoidanit.laptopshop.entity.Role;
import vn.hoidanit.laptopshop.entity.User;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.services.RoleService;
import vn.hoidanit.laptopshop.services.UploadService;
import vn.hoidanit.laptopshop.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Controller
public class UserController {

    private final RoleRepository roleRepository;
    private final UserService userService;
    private final UploadService uploadService;
    private final RoleService roleService;
    // private final UserRepository userRepository;

    public UserController(UserService userService, UploadService uploadService, RoleService roleService,
            RoleRepository roleRepository) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.roleService = roleService;
        this.roleRepository = roleRepository;

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
    @GetMapping("/admin/user/create")
    public String getCreate(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // POST
    @PostMapping("/admin/user/created")
    public String postCreate(@RequestParam("hoidanitFile") MultipartFile file, @ModelAttribute("newUser") User newUser,
            BindingResult result) {

        if (!file.isEmpty()) {
            String avtarPath = this.uploadService.handleUpload(file, "avatars");
            newUser.setAvatar(avtarPath);
        }
        Optional<Role> role = this.roleService.getRoleByName(newUser.getRole().getName());
        if (role.isPresent()) {
            newUser.setRole(role.get());
        }
        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

}
