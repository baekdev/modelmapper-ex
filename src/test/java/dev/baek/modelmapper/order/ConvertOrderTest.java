package dev.baek.modelmapper.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 *
 * @author baekdev
 * @since 2020-01-02
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ConvertOrderTest {

	@Test
	public void test_convert_order_to_dto() {
		Order order = new Order()
			.setCustomer(new Order.Customer()
				.setName(new Order.Name()
					.setFirstName("DEV")
					.setLastName("BAEK")))
			.setBillingAddress(new Order.Address()
				.setCity("SEOUL")
				.setStreet("GAROSU-GIL"));

		ModelMapper modelMapper = new ModelMapper();
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

		log.debug("order={}", order);
		log.debug("dto={}", orderDTO);

		Assert.assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
		Assert.assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
		Assert.assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
		Assert.assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
	}

}