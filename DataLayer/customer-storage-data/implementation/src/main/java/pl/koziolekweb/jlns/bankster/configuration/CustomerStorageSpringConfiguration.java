package pl.koziolekweb.jlns.bankster.configuration;

import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.interfaces.client.delegator.JLupinDelegator;
import com.jlupin.interfaces.common.enums.PortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.koziolekweb.jlns.bankster.service.interfaces.StorageCustomerBasicInformationService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("pl.koziolekweb.jlns.bankster")
public class CustomerStorageSpringConfiguration {
	@Bean
	public JLupinDelegator getJLupinDelegator() {
		return JLupinClientUtil.generateInnerMicroserviceLoadBalancerDelegator(PortType.JLRMC);
	}

	@Bean(name = "jLupinRegularExpressionToRemotelyEnabled")
	public List getRemotelyBeanList() {
		List<String> list = new ArrayList<>();
		list.add(StorageCustomerBasicInformationService.name);
		return list;
	}

	@Bean(name="storagePath")
	public Path storagePath(){
		return Paths.get("./customer-storage").toAbsolutePath();
	}

	@Bean(name="useRoyalFoodTester")
	public boolean useRoyalFoodTester(){
		return false;
	}
}

