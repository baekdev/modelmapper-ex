package dev.baek.modelmapper.book;

/**
 *
 * @author baekdev
 * @since 2020-01-02
 */
public enum CurrencyType {
	DOLLAR("dollar"),
	WON("won");

	private String name;

	CurrencyType(String name) {
		this.name = name;
	}
}
