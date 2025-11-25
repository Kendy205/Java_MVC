package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.entity.User;

//query keyword :https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @SuppressWarnings({ "null", "unchecked" })
    User save(User user);

    // findFirstBy...(findTop1By..)
    List<User> findAll();

    User findByIdOrEmail(long id, String email);
}
