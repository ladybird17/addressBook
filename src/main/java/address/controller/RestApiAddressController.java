package address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import address.dto.AddressDto;
import address.service.AddressService;

@RestController
public class RestApiAddressController {
	@Autowired
	private AddressService addressService;
	
	//게시판 전체 리스트
	@RequestMapping(value="/api/address",method=RequestMethod.GET)
	public List<AddressDto> restApiOpenAddressList() throws Exception{
		
		return addressService.selectAddressList();
	}
	
	//게시글 상세 조회
	@RequestMapping(value="/api/address/{num}",method=RequestMethod.GET)
	public AddressDto restApiOpenAddressDetail(@PathVariable("num") int num) throws Exception{
		
		return addressService.selectAddressDetail(num);
	}
	
	//새 게시글 삽입
	/*
	- @RequestBody 어노테이션은 메서드의 파라미터가
	- 반드시 HTTP 패킷의 바디에 담겨있어야 한다는 의미.
	POST, PUT을 사용하는 경우에는 메서드에 @RequestBody 어노테이션을 사용해야함.
	*/
	@RequestMapping(value="/api/address/write", method=RequestMethod.POST)
	public void restApiInsertAddress(@RequestBody AddressDto address) throws Exception{
		addressService.insertAddress(address);
	}
	
	//수정
	@RequestMapping(value="/api/address/{num}", method=RequestMethod.PUT)
	public String restApiUpdateAddress(@RequestBody AddressDto address) throws Exception{
		addressService.updateAddress(address);
		
		return "redirect:/address";
	}
	
	//삭제
	@RequestMapping(value="/api/address/{boardIdx}", method=RequestMethod.DELETE)
	public String restApiDeleteAddress(@PathVariable("num") int num) throws Exception{
		addressService.deleteAddress(num);
		
		return "redirect:/address";
	}
	
}
