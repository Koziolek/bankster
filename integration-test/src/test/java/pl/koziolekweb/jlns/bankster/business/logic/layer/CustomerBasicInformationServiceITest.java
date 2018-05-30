package pl.koziolekweb.jlns.bankster.business.logic.layer;

import com.jlupin.impl.client.util.JLupinClientUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pl.koziolekweb.jlns.bankster.base.BaseTest;
import pl.koziolekweb.jlns.bankster.service.interfaces.CustomerBasicInformationService;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(PER_CLASS)
public class CustomerBasicInformationServiceITest extends BaseTest {

	@Test
	public void exampleTest() {
		CustomerBasicInformationService service = JLupinClientUtil
				.generateRemote(getJLupinDelegator(),
						"customer",
						CustomerBasicInformationService.name,
						CustomerBasicInformationService.class);
		Assertions.assertThat(service.all()).isEmpty();
	}
}