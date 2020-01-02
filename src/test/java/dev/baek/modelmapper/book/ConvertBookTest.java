package dev.baek.modelmapper.book;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

/**
 *
 * @author baekdev
 * @since 2020-01-02
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ConvertBookTest {

	@Test
	public void test_manual_convert() {

		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("How to use Model Mapper?");
		bookDTO.setAuthor("BAEKDEV");
		bookDTO.setPrice(9000L);
		bookDTO.setPublishedAt(new Date());
		bookDTO.setCurrencyType(CurrencyType.WON);

		BookVO bookVO = convert(bookDTO);
		Assertions.assertThat(bookDTO.getAuthor()).isEqualTo(bookVO.getAuthor());

	}

	private BookVO convert(BookDTO bookDTO) {
		BookVO bookVO = new BookVO();
		bookVO.setTitle(bookDTO.getTitle());
		bookVO.setAuthor(bookDTO.getTitle()); // 다른 필드를 set 해줬지만 컴파일 에러가 없기 때문에 인지하기 어렵습니다.
		bookVO.setSubTitle(bookDTO.getSubTitle());
		bookVO.setPrice(bookDTO.getPrice());
		bookVO.setCurrencyType(bookDTO.getCurrencyType());
		bookVO.setCreateAt(bookDTO.getPublishedAt());
		return bookVO;
	}

}