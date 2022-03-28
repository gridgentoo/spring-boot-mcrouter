package com.mcrouter.app.service;

import com.mcrouter.app.domain.User;
import net.spy.memcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    MemcachedClient client;

    public User createUser(String name) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        client.set(name,0,user);

        return user;
    }

    public User findUser(String name) {
        return (User) client.get(name);
    }

}
