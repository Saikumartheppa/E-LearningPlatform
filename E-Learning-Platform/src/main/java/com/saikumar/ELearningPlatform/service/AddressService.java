package com.saikumar.ELearningPlatform.service;

import com.saikumar.ELearningPlatform.model.Address;
import com.saikumar.ELearningPlatform.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;
    public String addAddress(Address address) {
        addressRepo.save(address);
        return "Address Added !!";
    }

    public Address getAddressById(Long addressId) {

        return   addressRepo.findByAddressId(addressId);
    }
    public String updateAddress(Address address) {
        Address existingAddress = addressRepo.findByAddressId(address.getAddressId());
        if(existingAddress == null)
            return "No such address exists !!";
        addressRepo.save(address);
        return "Address updated successfully !!";
    }

    public String deleteAddress(Long addressId) {
        if(!addressRepo.existsById(addressId))
            return "No such address exists !!!";
        addressRepo.deleteById(addressId);
        return "Address deleted successfully !!!";
    }

    public void removeAddress(long addressId) {
        addressRepo.deleteById(addressId);
    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public void save(Address address) {
        addressRepo.save(address);
    }
}
