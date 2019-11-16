package co.edu.unal.software_engineering.meetu.service;

import co.edu.unal.software_engineering.meetu.model.User;
import co.edu.unal.software_engineering.meetu.pojo.RegisterUserPOJO;
import co.edu.unal.software_engineering.meetu.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService{

    private final UserRepository userRepository;

    public UserService( UserRepository userRepository ){
        this.userRepository = userRepository;
    }

    public User findByEmail( String email ){
        return userRepository.findByEmail(  email );
    }

    public void save( User user ){
        userRepository.save( user );
    }

    public boolean isRightUser( RegisterUserPOJO user ){
        boolean correctness = user.getPassword( ) != null && user.getUsername( ) != null;
        if( correctness ){
            correctness = !user.getUsername( ).trim( ).isEmpty( )
                    && !user.getLast_name( ).trim( ).isEmpty( )
                    && !user.getCity( ).trim( ).isEmpty( )
                    && !user.getEmail( ).trim( ).isEmpty( )
                    && !user.getPhone_number( ).trim( ).isEmpty( )
                    && !user.getPassword( ).trim( ).isEmpty( );
        }
        return correctness;
    }
}