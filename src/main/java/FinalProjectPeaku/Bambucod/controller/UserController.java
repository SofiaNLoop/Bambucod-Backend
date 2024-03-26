package FinalProjectPeaku.Bambucod.controller;


import FinalProjectPeaku.Bambucod.model.DTO.ScoreUpdateRequest;
import FinalProjectPeaku.Bambucod.model.entities.User;
import FinalProjectPeaku.Bambucod.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "list")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "get-score/{username}")
    public Integer getScore (@PathVariable String username){
        return userService.getScore(username);
    }

    @PatchMapping(value = "set-score/{username}")
    public Integer setScoreUser (@PathVariable String username, @RequestBody ScoreUpdateRequest scoreUpdateReq) {
        Integer intValue = userService.updateScore(username, scoreUpdateReq);
        return Objects.requireNonNullElse(intValue, 0);

    }



}
