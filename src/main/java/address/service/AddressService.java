package address.service;

import java.util.List;

import address.dto.AddressDto;

public interface AddressService {
	List<AddressDto> selectAddressList() throws Exception;
	
	AddressDto selectAddressDetail(int num) throws Exception;
	
	public void insertAddress(AddressDto address) throws Exception;
	
	void updateAddress(AddressDto address) throws Exception;
	
	void deleteAddress(int num) throws Exception;
}
