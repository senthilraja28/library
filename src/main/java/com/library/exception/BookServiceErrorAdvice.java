package com.library.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookServiceErrorAdvice {
	
	
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionEntity handle(ResourceNotFoundException ex, HttpServletResponse response) {
    	final ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setExceptionCause(ex.getMessage());
        exceptionEntity.setExceptionCode(HttpStatus.NOT_FOUND.value());
        return exceptionEntity;
    	
    	
    }

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class, NullPointerException.class, LibraryApplicationException.class})
	@ResponseBody
    public ExceptionEntity handleException(Exception ex, HttpServletResponse response) {
    	final ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setExceptionCause(ex.getMessage());
        exceptionEntity.setExceptionCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return exceptionEntity;
    	
    	
    }


}
