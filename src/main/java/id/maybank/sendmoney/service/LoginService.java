package id.maybank.sendmoney.service;

import id.maybank.sendmoney.entity.User;
import id.maybank.sendmoney.repository.RoleRepo;
import id.maybank.sendmoney.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    public User findUserByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }

}
