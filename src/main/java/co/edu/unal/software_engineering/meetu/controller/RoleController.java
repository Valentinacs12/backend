package co.edu.unal.software_engineering.meetu.controller;

import co.edu.unal.software_engineering.meetu.model.Role;
import co.edu.unal.software_engineering.meetu.service.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RoleController{

    private RoleService roleService;


    public RoleController( RoleService roleService ){
        this.roleService = roleService;
    }


    @GetMapping( value = { "/roles" } )
    public List<Role> getAllRoles( ){
        return roleService.getAll( );
    }
}
