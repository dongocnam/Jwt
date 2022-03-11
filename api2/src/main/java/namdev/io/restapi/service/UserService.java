package namdev.io.restapi.service;

import java.util.List;

import namdev.io.restapi.model.User;



public interface UserService {
	Iterable<User> findAll();
    List<User> search(String q);
    User findOne(long id);
    void save(User emp);
    void delete(User emp);
}