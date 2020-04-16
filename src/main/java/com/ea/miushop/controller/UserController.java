package com.ea.miushop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ea.miushop.domain.Role;
import com.ea.miushop.domain.User;
import com.ea.miushop.domain.User_Role;
import com.ea.miushop.service.RoleService;
import com.ea.miushop.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;
    
   
    @PostMapping(value="/signup")
    public ResponseEntity<?> create(@RequestBody User_Role userRole ){
    	
    	User userExists = userService.findUserByUserName(userRole.getUserName());
    	
    	if(userExists!=null) {
    		ResponseEntity.badRequest();
          }
            userService.saveUser(userRole);
            return ResponseEntity.accepted().build();
            
      }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/role")
    public ResponseEntity<?> createRole(@RequestParam("role") String role){
    	roleService.save(role);
        return ResponseEntity.accepted().build();
    }
    
    @GetMapping(value="/findbyemail")
	public User findByEmail(String email) {		
		return userService.findByEmail(email);

	}
    
    
    @GetMapping(value="/deactivate")
    public ResponseEntity<?> inActiveUser(@RequestParam("userId") Long userId){
    	userService.inActiveUser(userId);
    	return ResponseEntity.accepted().build();
    }
    
    @GetMapping(value="/activate")
    public ResponseEntity<?> activeUser(@RequestParam("userId") Long userId){
    	userService.activeUser(userId);
    	return ResponseEntity.accepted().build();
    }
 

}
