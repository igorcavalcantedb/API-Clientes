package com.compasso.selection.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import java.time.format.DateTimeParseException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.compasso.selection.exceptions.CityAlreadyExistsException;
import com.compasso.selection.exceptions.ClientNotFoundException;
import com.compasso.selection.exceptions.ErrorDetail;
import com.compasso.selection.exceptions.NameInvalidException;
import com.compasso.selection.exceptions.StateNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> handleClientNotFoundException(ClientNotFoundException exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Client not found.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(CityAlreadyExistsException.class)
    public ResponseEntity<?> handleCityAlreadyExistsException(CityAlreadyExistsException exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorDetail.setTitle("City Already Exists.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_ACCEPTABLE);
    }
	
	@ExceptionHandler(NameInvalidException.class)
    public ResponseEntity<?> handleNameInvalidException(NameInvalidException exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorDetail.setTitle("Name Invalid Exception.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_ACCEPTABLE);
    }
	
	@ExceptionHandler(StateNotFoundException.class)
    public ResponseEntity<?> handleNameInvalidException(StateNotFoundException exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("State not Found.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<?> handleNameInvalidException(DateTimeParseException exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorDetail.setTitle("Invalid date.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_ACCEPTABLE);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        errorDetail.setTitle("Invalid data.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_ACCEPTABLE);
    }
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception,
            HttpServletRequest request) {

        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Data not found.");
        errorDetail.setDetail(exception.getMessage());
        errorDetail.setDeveloperMessage(exception.getClass().getName());

        return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);
    }
	
}
