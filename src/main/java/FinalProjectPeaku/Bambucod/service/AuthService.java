package FinalProjectPeaku.Bambucod.service;

import FinalProjectPeaku.Bambucod.model.DTO.AuthResponse;
import FinalProjectPeaku.Bambucod.model.DTO.LoginRequest;
import FinalProjectPeaku.Bambucod.model.DTO.RegisterRequest;
import FinalProjectPeaku.Bambucod.model.entities.Role;
import FinalProjectPeaku.Bambucod.model.entities.User;
import FinalProjectPeaku.Bambucod.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
