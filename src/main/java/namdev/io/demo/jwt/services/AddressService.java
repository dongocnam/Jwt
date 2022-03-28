package namdev.io.demo.jwt.services;
import namdev.io.demo.jwt.entities.Address;
import namdev.io.demo.jwt.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Iterable<Address> findAll();
    //User search(String q);
    Address findOne(long id);
    void save(Address emp);
    void delete(Address emp);
}
