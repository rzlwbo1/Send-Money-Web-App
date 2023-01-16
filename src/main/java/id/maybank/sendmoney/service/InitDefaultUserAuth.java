package id.maybank.sendmoney.service;

import id.maybank.sendmoney.entity.Role;
import id.maybank.sendmoney.entity.User;
import id.maybank.sendmoney.repository.RoleRepo;
import id.maybank.sendmoney.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InitDefaultUserAuth {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @PostConstruct
    public void index() {

        // buat role
        Role roleAdmin = new Role();
        roleAdmin.setRole("ADMIN");
        this.roleRepo.save(roleAdmin);

        Role roleOperator = new Role();
        roleOperator.setRole("OPERATOR");
        this.roleRepo.save(roleOperator);

        Role roleCS = new Role();
        roleCS.setRole("CUSTOMER SERVICE");
        this.roleRepo.save(roleCS);



        // buat list role dan usernya

        List<Role> roleListAdmin = new ArrayList<>();
        roleListAdmin.add(roleAdmin);

        List<Role> roleListOperator = new ArrayList<>();
        roleListOperator.add(roleOperator);

        List<Role> roleListCS = new ArrayList<>();
        roleListCS.add(roleCS);

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userAdmin.setRoles(roleListAdmin);
        this.userRepo.save(userAdmin);

        User userOperator = new User();
        userOperator.setUsername("operator");
        userOperator.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userOperator.setRoles(roleListOperator);
        this.userRepo.save(userOperator);

        User userCS = new User();
        userCS.setUsername("customer");
        userCS.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userCS.setRoles(roleListCS);
        this.userRepo.save(userCS);

    }


}
