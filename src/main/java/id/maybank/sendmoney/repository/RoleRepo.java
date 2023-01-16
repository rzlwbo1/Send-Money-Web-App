package id.maybank.sendmoney.repository;

import id.maybank.sendmoney.entity.Role;
import id.maybank.sendmoney.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Long> {

    List<Role> findByUsers(User user);

}
