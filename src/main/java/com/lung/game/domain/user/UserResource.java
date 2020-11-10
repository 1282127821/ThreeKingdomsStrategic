package com.lung.game.domain.user;

import com.lung.game.mixed.RedisKeyPrefix;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/3 - 22:39
 * @implSpec 玩家 game resources
 */
@Slf4j
@Data
@NoArgsConstructor
@RedisHash(RedisKeyPrefix.User.USER_RESOURCE_KEY)
@Document
public class UserResource {

    /**
     * 主键：玩家ID
     */
    @Id
    @Field("_id")
    private Long uid;

    /**
     * 粮食产量
     */
    @Field("grain")
    private int grain;

    /**
     * 木材产量
     */
    @Field("wood")
    private int wood;

    /**
     * 铁矿产量
     */
    @Field("iron")
    private int iron;

    /**
     * 石料产量
     */
    @Field("stone")
    private int stone;

    /**
     * 铜币产量
     */
    @Field("copper")
    private int copper;

    public UserResource(Long uid) {
        this.uid = uid;
    }

    public void increment() {
        grain += 100;
        wood += 100;
        iron += 100;
        stone += 100;
        copper += 60;

        if (log.isInfoEnabled()) {
            log.info("user {} resource [ grain {},wood {},iron {},stone {},copper {} ] is increment",
                    uid, grain, wood, iron, stone, copper);
        }
    }



}
