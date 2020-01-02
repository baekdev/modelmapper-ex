package dev.baek.modelmapper.book;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 *
 * @author baekdev
 * @since 2020-01-02
 */
@Getter
@Setter
@ToString
public class BookVO {

	private String title;
	private String subTitle;
	private String author;
	private CurrencyType currencyType;
	private Date createAt;
	private Long price;
	
}
