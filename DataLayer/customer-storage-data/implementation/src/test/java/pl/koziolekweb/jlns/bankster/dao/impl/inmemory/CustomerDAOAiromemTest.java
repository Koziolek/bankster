package pl.koziolekweb.jlns.bankster.dao.impl.inmemory;

import io.vavr.control.Option;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.koziolekweb.jlns.bankster.dao.pojo.Customer;

import java.nio.file.Paths;
import java.util.UUID;

class CustomerDAOAiromemTest {

	private CustomerDAOAiromem sut;

	@BeforeEach
	void setUp() {
		sut = new CustomerDAOAiromem(Paths.get("./target", "customer-storage-test").toAbsolutePath(), false);
	}

	@Test
	void shouldSaveCustomer() {
		UUID add = sut.add(new Customer());
		Option<Customer> byId = sut.getById(add);
		Assertions.assertThat(byId).isNotEmpty();
	}
}