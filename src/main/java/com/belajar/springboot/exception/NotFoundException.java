package com.belajar.springboot.exception;

    public class NotFoundException extends RuntimeException{
        public NotFoundException(String message){
            super(message);
        }
    }

