package namdev.io.demo.jwt.controllers;
import namdev.io.demo.jwt.entities.Address;
import namdev.io.demo.jwt.services.AddressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private static Logger logger = Logger.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    private List<Address> address = new ArrayList<Address>();


    @GetMapping()
    public List<Address> getAll() {
        logger.info("===Information address===");
        return (List<Address>) addressService.findAll();
    }
    @PostMapping()
    public String create(@RequestBody Address address) {
        try {
            addressService.save(address);
            return "Add successful";
        } catch (Exception e) {
            return "Error";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {

        Address address = addressService.findOne(id);

        addressService.delete(address);
        return "delete successful";

    }
    @PutMapping("/{id}")
    public String updateAddress(@PathVariable(value = "id") Long id,@Valid @RequestBody Address addressDetails) {
        try {
            Address address = addressService.findOne(id);
            address.setName(addressDetails.getName());


            addressService.save(address);
            return "Update successfuly";
        }catch (Exception e) {
            return "Error";
        }
    }

//    @GetMapping("/address")
//    public List<Address> search(@RequestParam("s") String s) {
//        return addressService.search(s);
//    }
}

