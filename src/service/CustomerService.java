package service;
import model.Customer;

import java.util.*;

public class CustomerService {

    private static final HashSet<Customer> customers = new HashSet<>();

    private static final CustomerService customerService = null;
    private static CustomerService Instance;
    private CustomerService(){}
    public static CustomerService getCustomerService(){
        if (customerService== null){
        Instance = new CustomerService();}
        return Instance;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName, email));
        }
//add customer object to Hash-map
        public static Customer getCustomer(String customerEmail) {
            Optional<Customer> customer = customers.stream().filter(c -> customerEmail.equals(c.getEmail())).findFirst();
            //return the value of the specified key match
            return customer.orElse(null);
        }
//find customer according to it's email
        public Collection<Customer> getAllCustomers(){
            return customers;
        }
    }
//access method to get all customer information( first name, last name, email)



