package FinalProjectPeaku.Bambucod.controller;


import FinalProjectPeaku.Bambucod.model.DTO.ScoreUpdateRequest;
import FinalProjectPeaku.Bambucod.model.entities.User;
import FinalProjectPeaku.Bambucod.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "list")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }



    @PatchMapping(value = "set-score/{username}")
    public Integer setScoreUser (@PathVariable String username, @RequestBody ScoreUpdateRequest scoreUpdateReq) {
        return userService.updateScore(username, scoreUpdateReq);
    }



}
