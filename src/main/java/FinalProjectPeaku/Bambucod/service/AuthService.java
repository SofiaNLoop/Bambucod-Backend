package FinalProjectPeaku.Bambucod.service;

import FinalProjectPeaku.Bambucod.exceptions.NullException;
import FinalProjectPeaku.Bambucod.model.DTO.AuthResponse;
import FinalProjectPeaku.Bambucod.model.DTO.LoginRequest;
import FinalProjectPeaku.Bambucod.model.DTO.RegisterRequest;
import FinalProjectPeaku.Bambucod.model.entities.Role;
import FinalProjectPeaku.Bambucod.model.entities.User;
import FinalProjectPeaku.Bambucod.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public String login(LoginRequest request) {
        if (request.getUsername() == null || request.getPassword() == null){
            throw new NullException("null.fields", HttpStatus.BAD_REQUEST);
        } else {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    ));

            UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

            return jwtService.getToken(user);
        }

    }

    public String register(RegisterRequest request) {
        if (request.getUsername() == null || request.getPassword() == null){
            throw new NullException("null.fields", HttpStatus.BAD_REQUEST);
        } else{
            User user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .name(request.getName())
                    .lastName(request.getLastName())
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
            return "¡Usuario creado correctamente!";
        }

    }

}
