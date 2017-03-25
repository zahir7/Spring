package test.spring.mvc;

import java.io.File;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/*
 * 언로테이션
 * 	메소드나 클래스에 부가적인의미 부여.
 */

@Controller
public class HelloController {
	
	@RequestMapping("/form.do")
	public String form(){
		System.out.println("가가말언마ㅣ런ㅁㅇ;라ㅓㄴㅁ이;ㄹ");
		return "/test/form.jsp";
	}
	
//	포스트방식 전송일때.
//	@RequestMapping(value="/form.do" , method=RequestMethod.POST)
//	public String form(){
//		return "/test/form.jsp";
//	}
	
	
//	
//	@RequestMapping(value="/form.do")
//	public ModelAndView form3(){		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/test/form.jsp");
//		return mv;
//	}
	
//	@RequestMapping(value="formPro.do", method=RequestMethod.POST)
//	public ModelAndView formPro(HttpServletRequest request , HttpServletResponse response, HttpSession session, 
//								@ModelAttribute DTO dto){	
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("/test/formPro.jsp");
//		return mv;
//	}
	
	@RequestMapping(value="formPro.do", method=RequestMethod.POST)
	public ModelAndView formPro(@ModelAttribute DTO dto,
								MultipartHttpServletRequest request, 
								HttpSession session){	
		
		System.out.println("id  : "+ dto.getId());
		MultipartFile file =  request.getFile("upload");
		String fileName = file.getOriginalFilename();
		File saveFile = new File("d://save//"+fileName);
		try {
			file.transferTo(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.setAttribute("memId", dto.getId());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", dto);
		mv.setViewName("/test/formPro.jsp");
		return mv;
	}	
}

