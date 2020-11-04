package com.lung.game.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/3 - 22:39
 * @implSpec 玩家 game resources
 */
@Data
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

}
