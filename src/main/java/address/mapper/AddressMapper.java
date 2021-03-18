package address.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import address.dto.AddressDto;

@Mapper
public interface AddressMapper {
	//목록
	List<AddressDto> selectAddressList() throws Exception;
	
	//조회
	AddressDto selectAddressDetail(int num) throws Exception;
	
	//삽입
	void insertAddress(AddressDto address) throws Exception;
	
	//수정
	void updateAddress(AddressDto address) throws Exception;
	
	//삭제
	void deleteAddress(int num) throws Exception;
}
