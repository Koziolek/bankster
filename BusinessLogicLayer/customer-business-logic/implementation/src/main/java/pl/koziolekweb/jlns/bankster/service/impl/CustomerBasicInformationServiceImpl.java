package pl.koziolekweb.jlns.bankster.service.impl;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koziolekweb.jlns.bankster.common.pojo.BasicCustomerInformation;
import pl.koziolekweb.jlns.bankster.common.util.JLupinService;
import pl.koziolekweb.jlns.bankster.service.interfaces.CustomerBasicInformationService;
import pl.koziolekweb.jlns.bankster.service.interfaces.StorageCustomerBasicInformationService;

import java.util.UUID;

@JLupinService
@Service(value = CustomerBasicInformationService.name)
public class CustomerBasicInformationServiceImpl implements CustomerBasicInformationService {

	private final StorageCustomerBasicInformationService delegate;

	@Autowired
	public CustomerBasicInformationServiceImpl(StorageCustomerBasicInformationService delegate) {
		this.delegate = delegate;
	}

	@Override
	public Set<BasicCustomerInformation> all() {
		return delegate.all();
	}

	@Override
	public Option<BasicCustomerInformation> byId(UUID customerId) {
		return delegate.byId(customerId);
	}
}