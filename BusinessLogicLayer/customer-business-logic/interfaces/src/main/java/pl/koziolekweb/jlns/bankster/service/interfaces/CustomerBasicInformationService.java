package pl.koziolekweb.jlns.bankster.service.interfaces;

import io.vavr.collection.Set;
import io.vavr.control.Option;
import pl.koziolekweb.jlns.bankster.common.pojo.BasicCustomerInformation;

import java.util.UUID;

public interface CustomerBasicInformationService {

	String name="customerBasicInformationService";

	Set<BasicCustomerInformation> all();

	Option<BasicCustomerInformation> byId(UUID customerId);
}