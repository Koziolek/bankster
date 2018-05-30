package pl.koziolekweb.jlns.bankster.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Customer implements Serializable {

	private UUID customerId;

	public Customer() {
		this.customerId = UUID.randomUUID();
	}
}
