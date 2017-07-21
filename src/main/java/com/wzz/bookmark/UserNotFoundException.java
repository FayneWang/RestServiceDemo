package com.wzz.bookmark;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by WangZezhou(301255) on 2017/7/20.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId){
        super("could not find user '"+userId+"'.");
    }
}
