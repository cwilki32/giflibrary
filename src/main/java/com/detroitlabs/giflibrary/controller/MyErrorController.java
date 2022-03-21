package com.detroitlabs.giflibrary.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class MyErrorController implements ErrorController { //error controller interface


    @RequestMapping("/error")
    public String handleError() {
        //do something like logging, can specify the type of error and handling here
                return "error";
            }



    @Override
    public String getErrorPath() {
        return null;
    }
}





//        @GetMapping(value = "/error")
//        public String handleError(HttpServletRequest request) {
//            //do something like logging, can specify the type of error and handling here
//            Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//            if (status != null) {
//                Integer statusCode = Integer.valueOf(status.toString());
//
//                if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                    return "error-404";
//                }
//            }
//            return "error"; //custom page from error.html
//        }

