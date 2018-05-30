package pl.koziolekweb.jlns.bankster.dao.interfaces;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import pl.koziolekweb.jlns.bankster.dao.pojo.Customer;

import java.util.UUID;

public interface CustomerDAO {

	Option<Customer> getById(UUID customerId);

	Set<Customer> all();

	UUID add(Customer newCustomer);
}