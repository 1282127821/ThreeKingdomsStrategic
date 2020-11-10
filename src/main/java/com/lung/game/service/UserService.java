package com.lung.game.service;

import com.lung.game.cache.UserPlayerCache;
import com.lung.game.cache.UserResourceCache;
import com.lung.game.domain.user.UserProfile;
import com.lung.game.domain.user.UserResource;
import com.lung.game.repository.UserProfileRepository;
import com.lung.game.repository.UserResourceRepository;
import com.lung.game.utils.EncryptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:25
 * @implSpec
 */
@Slf4j
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

    public UserProfile login(UserProfile user) {
        if (log.isInfoEnabled()) {
            log.info("User login account={}, password={}", user.getName(), user.getPassword());
        }

        // encrypt password
        user.setPassword(EncryptionUtils.encrypt(user.getPassword()));
        UserProfile saved = userPlayerCache.save(user);

        UserResource initResource = new UserResource(saved.getId());
        userResourceCache.save(initResource);
        // TODO test mongo
        userProfileRepository.save(user);
        userResourceRepository.save(initResource);

        return saved;
    }

    public void register(UserProfile user) { // encrypt password
        user.setPassword(EncryptionUtils.encrypt(user.getPassword()));
        UserProfile saved = userPlayerCache.save(user);

        UserResource initResource = new UserResource(saved.getId());
        userResourceCache.save(initResource);
        // TODO test mongo
        userProfileRepository.save(user);
        userResourceRepository.save(initResource);

    }


}
