package com.hongdy.code.controller;


import com.hongdy.code.dto.User;
import com.hongdy.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Login {

    @Autowired
    private UserService userService;


    @GetMapping("/selecttest1")
    public ResponseEntity<Object> selecttest1() {

        User user = userService.select("1");

        return new ResponseEntity<>("selecttest1", HttpStatus.OK);
    }

    @PostMapping("/insertest2")
    public ResponseEntity<Object> insertest2() throws Exception {
        User user = new User();
        user.setId("2");
        user.setName("3");
        userService.insert(user);

        return new ResponseEntity<>("insertest2", HttpStatus.OK);
    }

}
