package com.lti.mod.services.coreservices.controller;

import com.lti.mod.services.coreservices.model.UserDao;
import com.lti.mod.services.coreservices.model.UserDto;
import com.lti.mod.services.coreservices.repository.UserRepository;
import com.lti.mod.services.coreservices.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class UserController {
    @Autowired
    private UserRegistrationService userDetailsService;
    @Autowired
    private UserRepository userDao;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        System.out.println("Saved ##########");
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody UserDto user) throws Exception {
        System.out.println(user.getEmail());
        UserDao usr = userDao.findByEmail(user.getEmail());
        return new ResponseEntity<>(usr , HttpStatus.OK);
    }
}
