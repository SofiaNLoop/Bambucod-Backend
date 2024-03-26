package FinalProjectPeaku.Bambucod.service;

import FinalProjectPeaku.Bambucod.exceptions.MessageException;
import FinalProjectPeaku.Bambucod.model.DTO.ScoreUpdateRequest;
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
            throw new MessageException("user.not.found", HttpStatus.NOT_FOUND);
        }
    }

    public User createUpdateUser(User user){
        if( userRepository.findByUsername(user.getUsername()).isPresent() ){
            throw new MessageException("username.duplicated", HttpStatus.NOT_FOUND);
        } else {
            return userRepository.save(user);
        }
    }


    public Integer updateScore(String username, ScoreUpdateRequest scoreUpdateReq) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new MessageException("user.not.found", HttpStatus.OK));

        if(user.getScore() == null || user.getScore() == 0 ){
            user.setScore(scoreUpdateReq.getScore());
        } else {
            user.setScore(user.getScore()+scoreUpdateReq.getScore());
        }
        userRepository.save(user);
        return user.getScore();

    }
}
