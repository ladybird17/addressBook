package address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import address.dto.AddressDto;
import address.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//게시판 전체 목록 페이지
	@RequestMapping("/address/openAddressList.do")
	public ModelAndView openAddressList() throws Exception{
		ModelAndView mv = new ModelAndView("/address/addressList");
		
		List<AddressDto> list = addressService.selectAddressList();
		mv.addObject("data", list);
		
		return mv;
	}
	
	//게시글 상세 조회
	@RequestMapping("/address/openAddressDetail.do")
	public ModelAndView openAddressDetail(@RequestParam int num) throws Exception{
		ModelAndView mv = new ModelAndView("/address/addressDetail");
		
		AddressDto address = addressService.selectAddressDetail(num);
		mv.addObject("address", address);
		
		return mv;
	}
	
	//삽입 페이지 출력
	@RequestMapping("/address/openAddressWrite.do")
	public String openAddressWrite() throws Exception{
		return "/address/addressWrite";
	}
	
	//새 게시글 삽입
	@RequestMapping("/address/insertAddress.do")
	public String insertAddress(AddressDto address) throws Exception{
		addressService.insertAddress(address);
		
		return "redirect:/address/openAddressList.do";
	}
	
	//수정
	@RequestMapping("/address/updateAddress.do")
	public String updateAddress(AddressDto address) throws Exception{
		addressService.updateAddress(address);
		
		return "redirect:/address/openAddressList.do";
	}
	
	//삭제
	@RequestMapping("/address/deleteAddress.do")
	public String deleteAddress(int num) throws Exception{
		addressService.deleteAddress(num);
		
		return "redirect:/address/openAddressList.do";
	}
	

}
