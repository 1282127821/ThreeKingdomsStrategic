package com.lung.game.cache;

import com.lung.game.domain.UserProfile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:28
 * @implSpec
 */
@Component
public class UserPlayerCache {

    private final static String USER_CACHE_KEY = "user_cache_key_";

    @Resource
    RedisTemplate<Long, UserProfile> redisTemplate;

    public void insert(UserProfile userProfile){
        redisTemplate.opsForHash().put(1000L,USER_CACHE_KEY + userProfile.getId(), userProfile);
    }



}
