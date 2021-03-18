package address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import address.dto.AddressDto;
import address.service.AddressService;

@Controller
public class RestAddressController {
	@Autowired
	private AddressService addressService;
	
	//게시판 전체 목록 페이지
	@RequestMapping(value="/address",method=RequestMethod.GET)
	public ModelAndView openAddressList() throws Exception{
		ModelAndView mv = new ModelAndView("/address/addressList");
		
		List<AddressDto> list = addressService.selectAddressList();
		mv.addObject("data", list);
		
		return mv;
	}
	
	//게시글 상세 조회
	@RequestMapping(value="/address/{num}",method=RequestMethod.GET)
	public ModelAndView openAddressDetail(@PathVariable("num") int num) throws Exception{
		ModelAndView mv = new ModelAndView("/address/addressDetail");
		
		AddressDto address = addressService.selectAddressDetail(num);
		mv.addObject("address", address);
		
		return mv;
	}
	
	//삽입 페이지 출력
	@RequestMapping(value="/address/write",method=RequestMethod.GET)
	public String openAddressWrite() throws Exception{
		return "/address/addressWrite";
	}
	
	//새 게시글 삽입
	@RequestMapping(value="/address/write", method=RequestMethod.POST)
	public String insertAddress(AddressDto address) throws Exception{
		addressService.insertAddress(address);
		
		return "redirect:/address";
	}
	
	//수정
	@RequestMapping(value="/address/{num}", method=RequestMethod.PUT)
	public String updateAddress(AddressDto address) throws Exception{
		addressService.updateAddress(address);
		
		return "redirect:/address";
	}
	
	//삭제
	@RequestMapping(value="/address/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteAddress(@PathVariable("num") int num) throws Exception{
		addressService.deleteAddress(num);
		
		return "redirect:/address";
	}
	
}