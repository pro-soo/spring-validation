package egovframework.example.open;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Validation을 위한 컨트롤러
 * @author prosoo
 *
 */
@Controller
public class ValidationController {
	
	@Autowired
	PersonValidator pv;
	
	// 바인딩
	@InitBinder
	public void webBinder(WebDataBinder binder) {
		binder.addValidators(pv);
	}
	
	@RequestMapping("/test.do")
	public String openTest(@ModelAttribute("person")Person p, Model model) throws Exception{
		System.out.println("시작");
		
		model.addAttribute("person", p);
		return "open/valTest";
	}
	
	@RequestMapping(value = "/startVal.do", method = RequestMethod.POST)
	public String validation(@Valid @ModelAttribute("person")Person p, BindingResult br) throws Exception{
		System.out.println("=======Start Validation !! ========");
		System.out.println(p.toString());
		// 에러 발생시 이전 페이지로 return + error Message 출력
		if (br.hasErrors()) {
			return "open/valTest";
		}
		
		return "";
	}
}
