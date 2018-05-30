package pl.koziolekweb.jlns.bankster.configuration;

import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.interfaces.client.delegator.JLupinDelegator;
import com.jlupin.interfaces.common.enums.PortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.koziolekweb.jlns.bankster.service.CustomerServiceName;
import pl.koziolekweb.jlns.bankster.service.interfaces.CustomerBasicInformationService;

@Configuration
@ComponentScan({
		"pl.koziolekweb.jlns.bankster",
		"com.jlupin.servlet.monitor.configuration"
})
public class GatewaySpringConfiguration {
	@Bean
	public JLupinDelegator getJLupinDelegator() {
		return JLupinClientUtil.generateInnerMicroserviceLoadBalancerDelegator(PortType.JLRMC);
	}

	@Bean(name = CustomerBasicInformationService.name)
	public CustomerBasicInformationService getCustomerBasicInformationService() {
		return JLupinClientUtil.generateRemote(getJLupinDelegator(),
				CustomerServiceName.NAME,
				CustomerBasicInformationService.name,
				CustomerBasicInformationService.class);
	}
}

