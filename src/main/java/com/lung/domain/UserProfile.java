package com.lung.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/3 - 19:18
 * @implSpec
 */
@Data
@Document
public class UserProfile {

    @Id
    @Field("_id")
    private Long id;

    /**
     *
     */
    @Field("name")
    private String name;

    /**
     *
     */
    @Field("password")
    private String password;

    /**
     *
     */
    @Field("email")
    private String email;

    /**
     *
     */
    @Field("phone")
    private String phone;

    /**
     *
     */
    @Field("level")
    private int level;

    /**
     * 是否购买金卡
     */
    @Field("goldCard")
    private boolean goldCard;

    /**
     *
     */
    @Field("goldTick")
    private Long goldTick;

    /**
     *
     */
    @Field("silverCard")
    private boolean silverCard;

    /**
     *
     */
    @Field("silverTick")
    private Long silverTick;

}

