package edu.umd.enpm614.assignment4.controller;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {
    private static final Logger logger = LoggerFactory.getLogger(FormController.class);
    private static final List<String> validColors = Arrays.asList("red", "white", "blue");

    @GetMapping("/form")
    public String getForm() {
        return "form";
    }

    @PostMapping("/form")
    public String postForm(@RequestParam(name = "email", required = false) String email,
                           @RequestParam(name = "color", required = false) String color,
                           @RequestParam(name = "isAgreed", required = false) boolean isAgreed,
                           Model model) {
        logger.debug("Calling post form");
        if (isAgreed && isEmailValid(email) && isColorValid(color)) {
            model.addAttribute("email", email);
            model.addAttribute("color", color);
            return "review";
        } else {
            if (!isAgreed) {
                model.addAttribute("agreeError", "You must agree to submit form.");
            }
            if (!isEmailValid(email)) {
                model.addAttribute("emailError", "Email must end with '@umd.edu'.");
            }
            if (!isColorValid(color)) {
                model.addAttribute("colorError", "You must pick a color.");
            }
            return "form";
        }
    }

    private boolean isEmailValid(String email) {
        return (Strings.isNotBlank(email) && email.trim().endsWith("@umd.edu"));
    }

    private boolean isColorValid(String color) {
        return validColors.contains(color);
    }
}
