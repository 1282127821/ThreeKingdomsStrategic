package com.lung.game.cache;

import com.lung.game.domain.UserProfile;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:28
 * @implSpec
 */
@Repository
public interface UserPlayerCache extends KeyValueRepository<UserProfile, Long> {

}
