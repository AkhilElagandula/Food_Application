package com.niit.project.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="Password Does not Match")
public class PasswordDoesNotMatchException extends Exception{
}
