package com.example.springdrools.controller;


import com.example.springdrools.model.Customer;
import com.example.springdrools.model.Product;
import com.example.springdrools.model.TypeEnum;
import com.example.springdrools.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author z.Taghizadeh
 */
@RestController
@RequestMapping(path = "/drools")
public class DroolsController {

    private final DroolsService droolsService;

    @Autowired
    public DroolsController(DroolsService droolsService) {
        this.droolsService = droolsService;
    }

    @GetMapping(value = "/getDiscount/{type}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getDiscount(@PathVariable TypeEnum type) {

        Product product = new Product();
        product.setType(type.getType());
        return droolsService.productRules(product);

    }

    @GetMapping(value = "/checkCode/{pinCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductByPinCode(@PathVariable int pinCode) {

        Product product = new Product();
        product.setCode(pinCode);
        return droolsService.productRules(product);

    }

    @GetMapping(value = "/getDiscountAndCode/{type}/{pinCode}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product callAllRule(@PathVariable TypeEnum type, @PathVariable int pinCode) {

        Product product = new Product();
        product.setType(type.getType());
        product.setCode(pinCode);
        return droolsService.productRules(product);

    }

    @GetMapping(value = "/getDiscountCustomer/{name}/{age}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getDiscountCustomer(@PathVariable int age, @PathVariable String name) {

        Customer customer = new Customer(name);
        customer.setAge(age);
        return droolsService.customerRules(customer);

    }
}
