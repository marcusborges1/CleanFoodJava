package database;

import domain.Customer;
import domain.Customers;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository implements Customers {
    static List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void deleteAll() {
        customers.clear();
    }
}
