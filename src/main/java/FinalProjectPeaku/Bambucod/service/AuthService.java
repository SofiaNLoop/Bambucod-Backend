package FinalProjectPeaku.Bambucod.service;

import FinalProjectPeaku.Bambucod.exceptions.MessageException;
import FinalProjectPeaku.Bambucod.model.DTO.LoginRequest;
import FinalProjectPeaku.Bambucod.model.DTO.RegisterRequest;
import FinalProjectPeaku.Bambucod.model.entities.Role;
import FinalProjectPeaku.Bambucod.model.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public String login(LoginRequest request) {
        validateEmptyUsernameAndPassword(request.getUsername(), request.getPassword());

        UserDetails user = userService.getByUsername(request.getUsername());

        validatePassword(request.getPassword(), user.getPassword());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return jwtService.getToken(user);
    }

    public String register(RegisterRequest request) {
        validateEmptyUsernameAndPassword(request.getUsername(), request.getPassword());

        User user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .lastName(request.getLastName())
                    .role(Role.USER)
                    .build();
            userService.createUpdateUser(user);

        return "¡Usuario creado correctamente!";
    }

    public void validateEmptyUsernameAndPassword(String username, String password){
        if(!StringUtils.hasText(username) || !StringUtils.hasText(password)){
            throw new MessageException("empty.fields", HttpStatus.BAD_REQUEST);
        }
    }

    public void validatePassword(String passwordReq, String passwordDB){
        boolean isCorrectPassword = passwordEncoder.matches(passwordReq, passwordDB);
        if(!isCorrectPassword){
            throw new MessageException("incorrect.password", HttpStatus.BAD_REQUEST);
        }
    }


}
