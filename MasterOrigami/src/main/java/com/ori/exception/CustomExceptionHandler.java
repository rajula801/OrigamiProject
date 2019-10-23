package com.ori.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
//        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
//        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
// 
//    @ExceptionHandler(RecordNotFoundException.class)
//    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex) {
//    	ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
//        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
//    }
//    
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
//    	ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
//        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(StudentNotFoundException.class)
//    public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex) {
//    	ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
//        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
//    }
//    
	@Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, 
			   HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
    
	   @ExceptionHandler(StudentNotFoundException.class)
	   protected ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex) {
		   ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	    }	  
    	   @ExceptionHandler(EntityNotFoundException.class)
    	   protected ResponseEntity<Object> handleEntityNotFound(
    	           EntityNotFoundException ex) {
    	       ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
    	       apiError.setMessage(ex.getMessage());
    	       return buildResponseEntity(apiError);
    	   }

    	   //other exception handlers
 
}