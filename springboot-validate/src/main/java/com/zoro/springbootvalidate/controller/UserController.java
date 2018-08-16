package com.zoro.springbootvalidate.controller;

import com.zoro.springbootvalidate.domian.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created on 2018/8/16.
 *
 * @author dubber
 */

@RestController
public class UserController {

    @PostMapping(value = "/user/save")
    public User save(@Valid @RequestBody User user) {

        return user;
    }

    @PostMapping(value = "/user/save2")
    public User save2(@Valid @RequestBody User user) {

        // spring api
        Assert.hasText(user.getName(), "姓名不可为空！");

        // jdk 自带
        assert user.getId() > 3;

        return user;
    }
}
