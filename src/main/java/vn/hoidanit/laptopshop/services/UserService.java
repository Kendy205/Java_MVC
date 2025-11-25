package vn.hoidanit.laptopshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.entity.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String handleHomePage() {
        return "hehe";
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> handleGetAllUser() {
        return this.userRepository.findAll();
    }

    public User getUserByIdOrEmail(long id, String email) {
        return this.userRepository.findByIdOrEmail(id, email);
    }
}
