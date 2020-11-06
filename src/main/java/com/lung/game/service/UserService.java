package com.lung.game.service;

import com.lung.game.cache.UserPlayerCache;
import com.lung.game.cache.UserResourceCache;
import com.lung.game.domain.UserProfile;
import com.lung.game.domain.UserResource;
import com.lung.game.repository.UserProfileRepository;
import com.lung.game.repository.UserResourceRepository;
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
    UserResourceRepository userResourceRepository;


    @Resource
    UserPlayerCache userPlayerCache;
    @Resource
    UserResourceCache userResourceCache;

    public void login(UserProfile user) {
        UserProfile saved = userPlayerCache.save(user);

        UserResource initResource = new UserResource(saved.getId());
        userResourceCache.save(initResource);
        // TODO test mongo
        userProfileRepository.save(user);
        userResourceRepository.save(initResource);

    }


}
