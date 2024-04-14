package com.relearn.rest.webservices.restwebservices.user;

import com.relearn.rest.webservices.restwebservices.jpa.UserRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

    //private UserDaoService service;

    private UserRepository userRepository;

    public UserJPAResource(UserRepository userRepository){
        //this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> findJPAAll(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/user/{id}")
    public EntityModel<User> finduserjpa(@PathVariable int id){
         Optional<User> user = userRepository.findById(id);

         if(user.isEmpty())
             throw new UserNotFoundException("id :"+ id);
        EntityModel<User> em = EntityModel.of(user.get());

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).findJPAAll());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/{id}")
    public void deleteUser(@PathVariable int id){
         userRepository.deleteById(id);
    }

}
