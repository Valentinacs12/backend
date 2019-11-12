package co.edu.unal.software_engineering.meetu.controller;

import co.edu.unal.software_engineering.meetu.model.User;
import co.edu.unal.software_engineering.meetu.pojo.RegisterUserPOJO;
import co.edu.unal.software_engineering.meetu.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@CrossOrigin
@RestController
public class UserController{

    private final UserService userService;


    public UserController( UserService userService){
        this.userService = userService;
    }


    @Bean
    public PasswordEncoder passwordEncoder( ){
        return new BCryptPasswordEncoder( );
    }

    @PostMapping( value = { "/registro/{roleId}" } )
    public ResponseEntity register( @PathVariable Integer roleId, @RequestBody RegisterUserPOJO userPOJO ){
        User existingUser = userService.findByUsername( userPOJO.getName( ) );
        if( existingUser != null || !userService.isRightUser( userPOJO ) ){
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }
        User newUser = new User( );
        newUser.setName( userPOJO.getName( ).toUpperCase( ) );
        newUser.setPassword( passwordEncoder( ).encode( userPOJO.getPassword( ) ) );
        userService.save( newUser );
        return new ResponseEntity( HttpStatus.CREATED );
    }
}