package com.web.project.webprojecttelerik.controllers;

import com.web.project.webprojecttelerik.exceptions.ForbiddenActionException;
import com.web.project.webprojecttelerik.exceptions.UnauthorizedOperationException;


import com.web.project.webprojecttelerik.models.UserSession;
import com.web.project.webprojecttelerik.models.dtos.UserDto;
import com.web.project.webprojecttelerik.services.contracts.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    private final RestTemplate restTemplate;

    private final AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service){
        this.service = service;
        this.restTemplate = new RestTemplate();
    }

    /**
     * Loges User in and returns a UserSession uuid
     * @param userInfo Authorization header, format "username password"
     * @return UserSession uuid field or HttpStatus 403
     */
    @GetMapping("/login")
    public UserSession login(@RequestHeader(HttpHeaders.AUTHORIZATION) String userInfo){

        String username = userInfo.split(" ")[0];
        String password = userInfo.split(" ")[1];
        try{
            return service.login(username, password);
        }catch (UnauthorizedOperationException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }

    }

    /**
     * Logout User, deletes UserSession associated with set User
     * @param uuid uuid of user to log out (UserSession uuid)
     * @return String or HttpStatus 403
     */
    @GetMapping("/logout")
    public String logout(@RequestHeader(HttpHeaders.AUTHORIZATION) String uuid){
        try{
            service.logout(uuid);
            return "Logged out";
        }catch (ForbiddenActionException | UnauthorizedOperationException e){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }

    /**
     * Creates new user
     * @param userDto json with register data
     * @return String "User created"
     */
    @PostMapping("/register")
    public String register(@RequestBody UserDto userDto){
        String url = "http://localhost:8080/api/users/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Map<String, Object> map = new HashMap<>();

        map.put("username", userDto.getUsername());
        map.put("password", userDto.getPassword());
        map.put("firstName", userDto.getFirstName());
        map.put("lastName", userDto.getLastName());
        map.put("email", userDto.getEmail());
        map.put("phoneNumber", userDto.getPhoneNumber());
        map.put("admin", userDto.isAdmin());

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<UserDto> response = restTemplate.postForEntity(url, entity, UserDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return "User created";
        } else {
            return response.toString();
        }

    }




}
