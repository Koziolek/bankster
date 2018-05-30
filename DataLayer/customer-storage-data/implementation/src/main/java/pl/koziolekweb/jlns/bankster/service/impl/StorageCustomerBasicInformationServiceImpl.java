package pl.koziolekweb.jlns.bankster.service.impl;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.koziolekweb.jlns.bankster.common.pojo.BasicCustomerInformation;
import pl.koziolekweb.jlns.bankster.dao.interfaces.CustomerDAO;
import pl.koziolekweb.jlns.bankster.dao.pojo.Customer;
import pl.koziolekweb.jlns.bankster.service.interfaces.StorageCustomerBasicInformationService;

import java.util.UUID;
import java.util.function.Function;

@Service(value = StorageCustomerBasicInformationService.name)
public class StorageCustomerBasicInformationServiceImpl implements StorageCustomerBasicInformationService {

	private final CustomerDAO customerDAO;

	private final Function<Customer, BasicCustomerInformation> mapper =
			customer -> new BasicCustomerInformation(customer.getCustomerId());

	@Autowired
	public StorageCustomerBasicInformationServiceImpl(
			@Qualifier(value = "customerDAO") CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}


	@Override
	public Set<BasicCustomerInformation> all() {
		return customerDAO.all()
				.map(mapper);
	}

	@Override
	public Option<BasicCustomerInformation> byId(UUID customerId) {
		return customerDAO.getById(customerId)
				.map(mapper);
	}
}