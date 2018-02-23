package com.raditia.repository;

import com.raditia.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {

    List<Address> findAllByCustomerId(String customerId);
    Address findAddressByIdAndCustomerId(String id, String customerId);
    boolean existsAddressByIdAndCustomerId(String id, String customerId);
    void deleteAddressByIdAndCustomerId(String id, String customerId);
}
