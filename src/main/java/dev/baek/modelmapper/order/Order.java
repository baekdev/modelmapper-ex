package dev.baek.modelmapper.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 *
 * @author baekdev
 * @since 2020-01-02
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Order {
	Customer customer;
	Address billingAddress;

	@Getter
	@Setter
	@ToString
	@Accessors(chain = true)
	public static class Customer {
		Name name;
	}

	@Getter
	@Setter
	@ToString
	@Accessors(chain = true)
	public static class Name {
		String firstName;
		String lastName;
	}

	@Getter
	@Setter
	@ToString
	@Accessors(chain = true)
	public static class Address {
		String street;
		String city;
	}

}