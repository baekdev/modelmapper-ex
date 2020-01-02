package dev.baek.modelmapper.book;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Date;

/**
 *
 * @author baekdev
 * @since 2020-01-02
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class ConvertBookTest {

	private BookDTO bookDTO;

	@Before
	public void setUp() {
		bookDTO = new BookDTO();
		bookDTO.setTitle("How to use Model Mapper?");
		bookDTO.setSubTitle("Intelligent, Easy, Convention Based, Extensible, Refactoring Safe");
		bookDTO.setAuthor("BAEKDEV");
		bookDTO.setPrice(9000L);
		bookDTO.setPublishedAt(new Date());
		bookDTO.setCurrencyType(CurrencyType.WON);
	}

	@Test
	public void test_manual_convert_mismatching_filed() {

		BookVO bookVO = new BookVO();
		bookVO.setTitle(bookDTO.getTitle());
		bookVO.setAuthor(bookDTO.getTitle()); // 다른 필드를 set 해줬지만 컴파일 에러가 없기 때문에 인지하기 어려움
		bookVO.setSubTitle(bookDTO.getSubTitle());
		bookVO.setPrice(bookDTO.getPrice());
		bookVO.setCurrencyType(bookDTO.getCurrencyType());
		bookVO.setCreateAt(bookDTO.getPublishedAt());

		Assertions.assertThat(bookDTO.getAuthor()).isNotEqualTo(bookVO.getAuthor());
	}

	@Test
	public void test_manual_convert_not_add_mapping_new_filed() {

		BookVO bookVO = new BookVO();
		bookVO.setTitle(bookDTO.getTitle());
		bookVO.setAuthor(bookDTO.getAuthor());
		// bookVO.setSubTitle(bookDTO.getSubTitle()); // subTitle 필드 매핑이 실제로 누락된 것을 주석으로 재연
		bookVO.setPrice(bookDTO.getPrice());
		bookVO.setCurrencyType(bookDTO.getCurrencyType());
		bookVO.setCreateAt(bookDTO.getPublishedAt());

		Assertions.assertThat(bookDTO.getSubTitle()).isNotEqualTo(bookVO.getSubTitle());
	}

	@Test
	public void test_use_model_mapper() {
		ModelMapper modelMapper = new ModelMapper();
		BookVO bookVO = modelMapper.map(bookDTO, BookVO.class);

		Assert.assertEquals(bookVO.getTitle(), bookDTO.getTitle());
		Assert.assertEquals(bookVO.getAuthor(), bookDTO.getAuthor());
		Assert.assertEquals(bookVO.getSubTitle(), bookDTO.getSubTitle());
		Assert.assertEquals(bookVO.getCurrencyType(), bookDTO.getCurrencyType());
	}

}