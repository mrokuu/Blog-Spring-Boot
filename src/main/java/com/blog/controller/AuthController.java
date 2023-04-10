package com.blog.controller;

import com.blog.dto.RegistrationDto;
import com.blog.entity.User;
import com.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model){
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);

        return "register";
    }
    @PostMapping("register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult bindingResult, Model model){
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            bindingResult.rejectValue("email", null, "There is already a user with same email");
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

}
