package com.lung.game.handler;

import com.lung.game.service.UserService;
import com.lung.game.web.bean.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:12
 * @implSpec
 */
@Slf4j
@RestController
@RequestMapping(value = "api/user", method = {RequestMethod.GET, RequestMethod.POST})
public class UserProfileHandler {

    @Resource
    UserService userService;

    @RequestMapping(value = "/login")
    public Response login() {



        return new Response().success();
    }



}
