package pl.koziolekweb.jlns.bankster.controller;

import io.vavr.collection.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.koziolekweb.jlns.bankster.common.pojo.BasicCustomerInformation;
import pl.koziolekweb.jlns.bankster.service.interfaces.CustomerBasicInformationService;

@RestController("/customer")
class CustomerBasicInformationController {

	private CustomerBasicInformationService backend;

	@GetMapping("all")
	public Set<BasicCustomerInformation> all(){
		return backend.all();
	}
}
