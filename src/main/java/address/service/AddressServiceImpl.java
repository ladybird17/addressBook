package address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import address.dto.AddressDto;
import address.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public List<AddressDto> selectAddressList() throws Exception {

		return addressMapper.selectAddressList();
	}

	@Override
	public AddressDto selectAddressDetail(int num) throws Exception {
		
		AddressDto address = addressMapper.selectAddressDetail(num);
		
		return address;
	}

	@Override
	public void insertAddress(AddressDto address) throws Exception {
		addressMapper.insertAddress(address);
	}

	@Override
	public void updateAddress(AddressDto address) throws Exception {
		addressMapper.updateAddress(address);
	}

	@Override
	public void deleteAddress(int num) throws Exception {
		addressMapper.deleteAddress(num);
	}

}
