package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.User;
import co.edu.unal.software_engineering.meetu.pojo.RegisterUserPOJO;
import co.edu.unal.software_engineering.meetu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository ){
        this.userRepository = userRepository;
    }


    public User findByUsername(String username ){
        return userRepository.findByUsername( username );
    }

    public void save( User user ){
        userRepository.save( user );
    }

    public boolean isRightUser( RegisterUserPOJO user ){
        boolean correctness = user.getName( ) != null;
        if( correctness ){
            correctness = !user.getName( ).trim( ).isEmpty( )
                    && !user.getPassword( ).trim( ).isEmpty( );
        }
        return correctness;
    }

}
