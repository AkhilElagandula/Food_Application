package com.niit.project.favouriteservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT , reason = "Cuisine Already Exist")
public class CuisineAlreadyExistException extends Exception{
}
