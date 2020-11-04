package com.lung.game.repository;

import com.lung.game.domain.UserResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/4 - 12:07
 * @implSpec
 */
@Repository
public interface UserResourceRepository extends MongoRepository<UserResource, Long> {
    
}
