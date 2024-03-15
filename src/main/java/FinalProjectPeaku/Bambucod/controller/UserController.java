package FinalProjectPeaku.Bambucod.controller;


import FinalProjectPeaku.Bambucod.model.entities.User;
import FinalProjectPeaku.Bambucod.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }


    @GetMapping
    public List<User> getAllStudents(){
        return this.userService.getUsers();
    }

//    @GetMapping
//    public String hello(){
//        return "Hello World!";
//    }





}
