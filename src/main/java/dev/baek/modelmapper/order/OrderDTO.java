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
public class OrderDTO {
	String customerFirstName;
	String customerLastName;
	String billingStreet;
	String billingCity;
}
