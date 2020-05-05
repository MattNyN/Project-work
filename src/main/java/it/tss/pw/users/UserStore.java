/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.users;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author matteo
 */
@ApplicationScoped
public class UserStore {

    private final Map<Long, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        Stream.of(new User(1l, "Rossi", "rossipwd"), new User(2l, "Verdi", "verdipwd"), new User(3l, "Bianchi", "bianchipwd"))
                .forEach(v -> users.put(v.getId(), v));
    }

    public Collection<User> all() {

        return users.values();
    }

    public User find (Long id){
        return users.get(id);
    }
    public User create(User u) {
        System.out.println("create user"+ u);
        return users.putIfAbsent(u.getId(), u);
    }

    public User update(User u) {
        System.out.println("update user" + u);
        return users.putIfAbsent(u.getId(), u);
    }

    public User delete(long id) {
       System.out.println("delete user"+ id);
        return users.remove(id);

    }

}
