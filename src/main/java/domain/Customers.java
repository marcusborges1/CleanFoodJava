package domain;

import java.util.List;

public interface Customers {
    List<Customer> getAll();
    void save(Customer customer);
    void deleteAll();
}
