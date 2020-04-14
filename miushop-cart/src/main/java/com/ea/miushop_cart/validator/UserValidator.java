package com.ea.miushop_cart.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ea.miushop.domain.User;
import com.ea.miushop.service.UserService;

public class UserValidator {
	@Component
	public class ItemNumValidator implements Validator {
		@Autowired
		private UserService userService;

		@Override
		public boolean supports(Class<?> clazz) {
			return User.class.isAssignableFrom(clazz);
		}

		@Override
		public void validate(Object target, Errors errors) {
//			User user = (User) target;
//			User userByEmail = userService.getUserByEmail(user.getEmail());
//			if (userByEmail != null) {
//				errors.rejectValue("email", "error.exists", new Object[] { user.getEmail() },
//						"Email " + user.getEmail() + " already in use");
//			}
		}
	}
}
