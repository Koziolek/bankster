package pl.koziolekweb.jlns.bankster.configuration;

import com.jlupin.impl.container.application.spring.JLupinAbstractSpringApplicationContainer;
import com.jlupin.interfaces.configuration.microservice.container.application.JLupinAbstractApplicationContainerProducer;
import com.jlupin.interfaces.container.application.JLupinApplicationContainer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CustomerStorageJLupinConfiguration extends JLupinAbstractApplicationContainerProducer {
	@Override
	public JLupinApplicationContainer produceJLupinApplicationContainer() {
		return new JLupinAbstractSpringApplicationContainer() {
			@Override
			public AbstractApplicationContext getAbstractApplicationContext() {
				return new AnnotationConfigApplicationContext(CustomerStorageSpringConfiguration.class);
			}
		};
	}
}