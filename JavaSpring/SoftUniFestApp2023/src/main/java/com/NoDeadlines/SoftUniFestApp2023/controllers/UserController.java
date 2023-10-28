package com.NoDeadlines.SoftUniFestApp2023.controllers;

import com.NoDeadlines.SoftUniFestApp2023.exceptions.DuplicateEntityException;
import com.NoDeadlines.SoftUniFestApp2023.exceptions.UnauthorizedOperationException;
import com.NoDeadlines.SoftUniFestApp2023.helpers.AuthenticationHelper;
import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.DTOs.BusinessUserDTO;
import com.NoDeadlines.SoftUniFestApp2023.models.User;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.NoDeadlines.SoftUniFestApp2023.models.mapper.ModelMapper;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private final ModelMapper mapper;


    private final UserService service;


    @Autowired
    public UserController(UserService service, ModelMapper mapper, AuthenticationHelper authenticationHelper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/businessusers")
    public List<BusinessUser> getBusinessUsers(

            @RequestParam(required = false) String username,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortOrder) {
        return service.getBusinessUsers();
    }







    @PostMapping("businessuser")
    public BusinessUser createBusinessUser(@RequestBody BusinessUserDTO userDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String userToken) {
        try {
            BusinessUser user = mapper.toBusinessUser(userDto);
            service.createBusinessUser(user, userToken);
            return user;
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (UnauthorizedOperationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }



//    @DeleteMapping
//    public void delete(@RequestParam String username, @RequestHeader(HttpHeaders.AUTHORIZATION) String userToken) {
//        try {
//            service.delete(username, userToken);
//        } catch (NoResultException | EntityNotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
//        } catch (UnauthorizedOperationException e) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
//        }
//    }


}
