package pl.koziolekweb.jlns.bankster.dao.impl.inmemory;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import pl.koziolekweb.jlns.bankster.dao.interfaces.CustomerDAO;
import pl.koziolekweb.jlns.bankster.dao.pojo.Customer;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


class CustomerDAOInMemory implements CustomerDAO, Serializable {

	private Map<UUID, Customer> storage = new ConcurrentHashMap<>();

	@Override
	public Option<Customer> getById(UUID customerId) {
		return Option.of(storage.get(customerId));
	}

	@Override
	public Set<Customer> all() {
		return storage.values()
				.stream()
				.collect(HashSet.collector());
	}

	@Override
	public UUID add(Customer newCustomer) {
		storage.put(newCustomer.getCustomerId(), newCustomer);
		return newCustomer.getCustomerId();
	}
}