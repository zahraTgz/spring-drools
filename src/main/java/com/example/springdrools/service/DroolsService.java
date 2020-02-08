package com.example.springdrools.service;


import com.example.springdrools.model.Customer;
import com.example.springdrools.model.Product;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author z.Taghizadeh
 */
@Service
public class DroolsService {

    private final KieContainer kieContainer;

    @Autowired
    public DroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Product productRules(Product product) {

        //get the stateful session
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(product);
        kieSession.fireAllRules();
        kieSession.dispose();
        return product;
    }

    public Customer customerRules(Customer customer) {

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(customer);
        kieSession.fireAllRules();
        kieSession.dispose();

        return customer;
    }

}
