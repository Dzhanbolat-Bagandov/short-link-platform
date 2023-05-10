package com.bagandov.redirectservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InterruptingException.class)
    public String interruptingExceptionHandler(
            final InterruptingException ex,
            Model model
    ) {
        model.addAttribute("errorHeader", "Wrong input");
        model.addAttribute("errorExplanation", "Something is wrong about your request. Try changing the input");
        model.addAttribute("message", ex.getUserMessage());
        return "customError";
    }
}
