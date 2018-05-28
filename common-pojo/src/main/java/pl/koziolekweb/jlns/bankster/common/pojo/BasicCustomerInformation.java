package pl.koziolekweb.jlns.bankster.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BasicCustomerInformation implements Serializable {

	private UUID customerId;

	public BasicCustomerInformation() {
		this.customerId = UUID.randomUUID();
	}
}
