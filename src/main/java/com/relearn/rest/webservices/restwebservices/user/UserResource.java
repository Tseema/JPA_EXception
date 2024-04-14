package com.relearn.rest.webservices.restwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    private UserDaoService service;

    public  UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> findall(){
        return service.findAll();
    }

    @GetMapping("/users/{Id}")
    public EntityModel<User> findUser(@PathVariable int Id){
        User user = service.findUser(Id);
        if(user==null)
            throw new UserNotFoundException("Id : "+ Id);

        EntityModel<User> entityuser = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findall());
        entityuser.add(link.withRel("all-users"));
        return entityuser;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
         User user1 = service.createUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(user1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{Id}")
    public void deleteUser(@PathVariable int Id){

         service.deleteUser(Id);

    }

}
