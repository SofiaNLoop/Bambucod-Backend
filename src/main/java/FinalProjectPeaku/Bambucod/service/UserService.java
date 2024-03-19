package FinalProjectPeaku.Bambucod.service;

import FinalProjectPeaku.Bambucod.exceptions.NullException;
import FinalProjectPeaku.Bambucod.model.entities.User;
import FinalProjectPeaku.Bambucod.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getByUsername(String username){
        if( userRepository.findByUsername(username).isPresent() ){
            return userRepository.findByUsername(username).get();
        } else {
            throw new NullException("user.not.found", HttpStatus.NOT_FOUND);
        }
    }
}
