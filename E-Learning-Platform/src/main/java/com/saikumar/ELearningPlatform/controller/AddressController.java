package com.saikumar.ELearningPlatform.controller;

import com.saikumar.ELearningPlatform.model.Address;
import com.saikumar.ELearningPlatform.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public String addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
    @GetMapping("address/{addressId}")
    public Address getAddressById(@PathVariable Long addressId){
        return addressService.getAddressById(addressId);
    }
    @PutMapping("address")
    public String updateAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }
    @DeleteMapping("address/{addressId}")
    public String deleteAddress(@PathVariable Long addressId){
        return addressService.deleteAddress(addressId);
    }

    @GetMapping("addresses")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }
}
