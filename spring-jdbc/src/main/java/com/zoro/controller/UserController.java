package com.zoro.controller;

import com.zoro.domain.User;
import com.zoro.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 用户 RestController on WebMVC
 **/
@RestController
public class UserController {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Resource
    private UserRepository userRepository;

    @PostMapping("/web/mvc/user/save")
    public Boolean save(@RequestBody User user) throws ExecutionException, InterruptedException, SQLException {
        /*
        Future<Boolean> future = executorService.submit(() -> {
            return userRepository.save(user);
        });
        return future.get();
        */

        System.out.printf("[Thread : %s ] UserController starts saving user...\n",
                Thread.currentThread().getName());
        return userRepository.save(user);
    }

}
