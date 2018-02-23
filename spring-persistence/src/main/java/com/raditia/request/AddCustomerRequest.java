package com.raditia.request;

import com.raditia.entity.Address;
import org.hibernate.validator.constraints.NotBlank;

public class AddCustomerRequest {

    @NotBlank
    private String name;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
