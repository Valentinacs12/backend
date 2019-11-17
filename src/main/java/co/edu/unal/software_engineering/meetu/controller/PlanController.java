package co.edu.unal.software_engineering.meetu.controller;

import co.edu.unal.software_engineering.meetu.model.Role;
import co.edu.unal.software_engineering.meetu.model.User;
import co.edu.unal.software_engineering.meetu.pojo.LoginUserPOJO;
import co.edu.unal.software_engineering.meetu.pojo.RegisterUserPOJO;
import co.edu.unal.software_engineering.meetu.service.RoleService;
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
public class PlanController {

    private final UserService userService;

    private final RoleService roleService;

    public PlanController(UserService userService, RoleService roleService ){
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostMapping( value = { "/plan" } )

    public ResponseEntity register( @PathVariable Integer roleId, @RequestBody RegisterUserPOJO userPOJO ){
    /*
        Role role = roleService.findById( roleId );
        User existingUser = userService.findByEmail( userPOJO.getEmail( ) );
        if( role == null || existingUser != null || !userService.isRightUser( userPOJO ) ){
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }
        User newUser = new User( );
        newUser.setUsername( userPOJO.getUsername( ).toLowerCase() );
        newUser.setLast_name(userPOJO.getLast_name().toLowerCase());
        newUser.setPhone_number(userPOJO.getPhone_number());
        newUser.setEmail(userPOJO.getEmail().toLowerCase());
        newUser.setCity(userPOJO.getCity().toLowerCase());
        newUser.setPassword(passwordEncoder().encode(userPOJO.getPassword()));
        newUser.setRoles( Collections.singletonList( role ) );

        userService.save( newUser );
        return new ResponseEntity( HttpStatus.CREATED );

     */
        return null;
    }


}