package com.relearn.rest.webservices.restwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();


    static {
        users.add(new User("see",1, LocalDate.now().minusYears(30)));
        users.add(new User("shru",2, LocalDate.now().minusYears(25)));
        users.add(new User("shil",3, LocalDate.now().minusYears(20)));
    }


    public List<User> findAll(){
        return users;
    }

    public User findUser(Integer Id) {
        //users.stream().anyMatch(Predicate.isEqual(id),Id);
        Predicate<? super User> predicate = user -> user.getId().equals(Id);
         return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUser(Integer Id) {
        Predicate<? super User> predicate = user -> user.getId().equals(Id);
        users.removeIf(predicate);
    }


    public User createUser(User user){
        users.add(user);
        return user;
    }
}
