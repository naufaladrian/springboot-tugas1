package com.belajar.springboot.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponseGenerator {

    public static <T> CommonResponse<T> successResponse(T data){
        CommonResponse<T> response = new CommonResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.name());
        response.setData(data);
        return response;
    }

    public static <T> ResponseEntity<CommonResponse<T>> errorResponse(String errors, int status, String message, HttpStatus httpStatus){
        CommonResponse<T> response = new CommonResponse<>();
        response.setStatus(status);
        response.setMessage(message);
        response.setData((T) errors);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
