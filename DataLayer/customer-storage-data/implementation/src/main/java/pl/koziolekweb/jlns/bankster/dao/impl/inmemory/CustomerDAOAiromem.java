package pl.koziolekweb.jlns.bankster.dao.impl.inmemory;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.koziolekweb.jlns.bankster.dao.interfaces.CustomerDAO;
import pl.koziolekweb.jlns.bankster.dao.pojo.Customer;
import pl.setblack.airomem.core.Persistent;

import javax.annotation.PreDestroy;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Repository(value = "customerDAO")
public class CustomerDAOAiromem implements CustomerDAO {

	private Persistent<CustomerDAOInMemory> controller;

	@Autowired
	public CustomerDAOAiromem(
			@Qualifier("storagePath") Path path,
			@Qualifier("useRoyalFoodTester") boolean useRoyalFoodTester) {
		Path resolve = Paths.get(path.toAbsolutePath().toString(), "customer");
		this.controller = Persistent.loadOptional(resolve,
				CustomerDAOInMemory::new, useRoyalFoodTester);
	}

	@Override
	public Option<Customer> getById(UUID customerId) {
		return controller.query(c -> c.getById(customerId));
	}

	@Override
	public Set<Customer> all() {
		return controller.query(CustomerDAOInMemory::all);
	}

	@Override
	public UUID add(Customer newCustomer) {
		return controller.executeAndQuery(c -> c.add(newCustomer));
	}

	@PreDestroy
	void close() {
		controller.close();
	}
}
