package com.belajar.springboot.exception;
import com.belajar.springboot.response.CommonResponseGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(NotFoundException notFoundException){
        return CommonResponseGenerator.errorResponse(notFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusiness(BusinessException businessException){
        return CommonResponseGenerator.errorResponse(businessException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
