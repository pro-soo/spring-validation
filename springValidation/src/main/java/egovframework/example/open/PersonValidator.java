package egovframework.example.open;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator{
	/**
	 * Person에 대한 Validator*/
	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}
	
	/**
	 * 오류메시지 설정*/
	@Override
	public void validate(Object target, Errors errors) {
		// 입력하지 않을 경우
		ValidationUtils.rejectIfEmpty(errors,"name", "open.name.empty", "이름을 입력해주세요.");
		ValidationUtils.rejectIfEmpty(errors,"age", "open.age.empty", "나이를 입력해주세요.");
		//
		Person p = (Person) target;
		// 이름에 대한 설정 (영어가 들어간 경우)
		List<Person> list = new ArrayList<Person>();
		list.add(p);
		for (int i = 0; i < list.size(); i++) {
			if (String.valueOf(p.getName().charAt(i)).matches("[\\s|a-z|A-Z|]*")) {
				errors.rejectValue("name", "open.name.en", "영어가 입력되었습니다.");
			}			
		}
		// 나이에 대한 설정
		if (p.getAge() < 0) {
			errors.rejectValue("age", "open.age.small", "나이가 너무 작습니다.");
		}else if (p.getAge() > 110) {
			errors.rejectValue("age", "open.age.large", "나이가 너무 많습니다.");
		}
	}

}
