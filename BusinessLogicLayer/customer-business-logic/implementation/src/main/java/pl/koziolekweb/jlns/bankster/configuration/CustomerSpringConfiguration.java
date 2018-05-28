package pl.koziolekweb.jlns.bankster.configuration;

import com.jlupin.impl.client.util.JLupinClientUtil;
import com.jlupin.interfaces.client.delegator.JLupinDelegator;
import com.jlupin.interfaces.common.enums.PortType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;
import pl.koziolekweb.jlns.bankster.common.util.JLupinService;
import pl.koziolekweb.jlns.bankster.service.interfaces.StorageCustomerBasicInformationService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@ComponentScan("pl.koziolekweb.jlns.bankster")
public class CustomerSpringConfiguration {
	@Bean
	public JLupinDelegator getJLupinDelegator() {
		return JLupinClientUtil.generateInnerMicroserviceLoadBalancerDelegator(PortType.JLRMC);
	}

	@Bean(name = StorageCustomerBasicInformationService.name)
	public StorageCustomerBasicInformationService getStorageCustomerBasicInformationService() {
		return JLupinClientUtil.generateRemote(getJLupinDelegator(),
				StorageCustomerBasicInformationService.name,
				StorageCustomerBasicInformationService.class);
	}

	@Bean(name = "jLupinRegularExpressionToRemotelyEnabled")
	public List getRemotelyBeanList() {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);

		scanner.addIncludeFilter(new AnnotationTypeFilter(JLupinService.class));

		List<String> list = scanner.findCandidateComponents("pl.koziolekweb.jlns.bankster.service.impl")
				.stream()
				.map(bd -> bd.getBeanClassName())
				.map(cn -> {
					try {
						return Class.forName(cn);
					} catch (ClassNotFoundException e) {
						return null;
					}
				})
				.filter(Objects::nonNull)
				.map(cl -> cl.getAnnotation(Service.class))
				.map(an -> an.value())
				.collect(Collectors.toList());
		return list;
	}
}

