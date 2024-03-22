package FinalProjectPeaku.Bambucod.controller;

import FinalProjectPeaku.Bambucod.model.DTO.AuthResponse;
import FinalProjectPeaku.Bambucod.model.DTO.LoginRequest;
import FinalProjectPeaku.Bambucod.model.DTO.RegisterRequest;
import FinalProjectPeaku.Bambucod.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(
                AuthResponse.builder()
                        .message(authService.login(request))
                        .build()
        );
    }

    @PostMapping(path = "/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(
                AuthResponse.builder()
                        .message(authService.register(request))
                        .build()
        );
    }
}
