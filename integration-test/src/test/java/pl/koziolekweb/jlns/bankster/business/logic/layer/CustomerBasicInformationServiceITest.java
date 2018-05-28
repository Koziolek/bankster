package pl.koziolekweb.jlns.bankster.business.logic.layer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.koziolekweb.jlns.bankster.base.BaseTest;
import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.interfaces.client.proxy.producer.JLupinProxyObjectProducer;
import pl.koziolekweb.jlns.bankster.service.interfaces.CustomerBasicInformationService;

public class CustomerBasicInformationServiceITest extends BaseTest {

	 @Test
	 public void exampleTest() {
	    CustomerBasicInformationService service = JLupinClientUtil.generateRemote(getJLupinDelegator(),
			    CustomerBasicInformationService.name,
			    CustomerBasicInformationService.class);
		 Assertions.assertThat(service.all()).isEmpty();
	 }
}