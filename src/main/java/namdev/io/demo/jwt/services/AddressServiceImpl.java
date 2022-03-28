package namdev.io.demo.jwt.services;

import namdev.io.demo.jwt.entities.Address;
import namdev.io.demo.jwt.entities.User;
import namdev.io.demo.jwt.repositories.AddressRepository;
import namdev.io.demo.jwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }
//    @Override
//    public User search(String q) {
//        return userRepository.findByUsername(q);
//    }
    @Override
    public Address findOne(long id) {
        return addressRepository.getById(id);
    }
    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }
}
