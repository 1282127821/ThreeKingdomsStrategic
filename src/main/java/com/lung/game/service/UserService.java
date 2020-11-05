package com.lung.game.service;

import com.lung.game.cache.UserPlayerCache;
import com.lung.game.domain.UserProfile;
import com.lung.game.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:25
 * @implSpec
 */
@Service
public class UserService {

    @Resource
    UserProfileRepository userProfileRepository;

    @Resource
    UserPlayerCache userPlayerCache;


    public void login(UserProfile user) {
        userPlayerCache.save(user);

        // TODO test mongo
        userProfileRepository.save(user);

    }


}
