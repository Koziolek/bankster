package pl.koziolekweb.jlns.bankster.service.impl;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;
import pl.koziolekweb.jlns.bankster.common.pojo.BasicCustomerInformation;
import pl.koziolekweb.jlns.bankster.service.interfaces.StorageCustomerBasicInformationService;

import java.util.UUID;

@Service(value = StorageCustomerBasicInformationService.name)
public class StorageCustomerBasicInformationServiceImpl implements StorageCustomerBasicInformationService {

	@Override
	public Set<BasicCustomerInformation> all() {
		return HashSet.empty();
	}

	@Override
	public Option<BasicCustomerInformation> byId(UUID customerId) {
		return Option.none();
	}
}