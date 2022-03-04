package com.example.Restapi.Controller;

import com.example.Restapi.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.*;

@RestController
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    private List<User> users = new ArrayList<User>();

    @PostMapping("/user")
    public User create(@RequestBody User user){
        logger.info("thong tin khach hang");
        users.add(user);
        return user;
    }
    @GetMapping("/users")
    public List<User> getAll(){
        return users;
    }
    @DeleteMapping("/user")
    public void delete(@RequestParam(name="id")int id){
        for(int i= 0; i < users.size(); i++){
            if (users.get(i).getId()== id){
                users.remove(i);
                break;
            }
        }
    }
    @PutMapping("/user")
    public void update(@RequestBody User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break;
            }
        }
    }
}



