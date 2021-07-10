package database;

import domain.Customer;
import domain.Customers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;

public class InMemoryCustomerRepositoryTest {
    @AfterEach
    void cleanUpEach() {
        Customers customersRepository = new InMemoryCustomerRepository();
        customersRepository.deleteAll();
    }

    @Nested
    @DisplayName("#getAll")
    class GetAll {
        @DisplayName("it saves a new customer when it does not exist in memory")
        @Test
        void testGetAllCustomersWhenThereAreNone() {
            Customers customersRepository = new InMemoryCustomerRepository();
            List<Customer> customers = customersRepository.getAll();

            assertThat(customers, empty());
        }
    }

    @Nested
    @DisplayName("#save")
    class Save {
        @DisplayName("it saves a new customer when it does not exist in memory")
        @Test
        void testAddsOneCustomerWhenItDoesNotExistInMemory() {
            Customer customer = new Customer("2851 Walnut Street, Meridian");
            Customers customersRepository = new InMemoryCustomerRepository();
            int previousCustomersCount = customersRepository.getAll().size();

            customersRepository.save(customer);

            assertThat(customersRepository.getAll(), hasSize(previousCustomersCount + 1));
        }

        @DisplayName("it updates a customer when it already exists in memory")
        @Test
        void testUpdateCustomerWhenItAlreadyExistsInMemory() {
            Customers customersRepository = new InMemoryCustomerRepository();
            Customer customer = new Customer("2851 Walnut Street, Meridian");
            customersRepository.save(customer);
            Customer sameCustomer = new Customer("3831 Orphan Road, Morris Chapel");


            assertThat(customersRepository.getAll(), hasSize(previousCustomersCount + 1));
        }
    }

    @Nested
    @DisplayName("#deleteAll")
    class DeleteAll {
        @DisplayName("it deletes all saved customers")
        @Test
        void testDeletesAllSavedCustomers() {
            Customer customer1 = new Customer("2851 Walnut Street, Meridian");
            Customer customer2 = new Customer("3831 Orphan Road, Morris Chapel");
            Customers customersRepository = new InMemoryCustomerRepository();
            customersRepository.save(customer1);
            customersRepository.save(customer2);

            customersRepository.deleteAll();

            assertThat(customersRepository.getAll(), hasSize(0));
        }
    }
}
