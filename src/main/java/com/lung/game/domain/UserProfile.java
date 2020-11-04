package com.lung.game.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/3 - 19:18
 * @implSpec user概况
 */
@Data
@Document
public class UserProfile {

    @Id
    @Field("_id")
    private Long id;

    /**
     * 玩家名称
     */
    @Field("name")
    private String name;

    /**
     * 密码
     */
    @Field("password")
    private String password;

    /**
     * 邮件
     */
    @Field("email")
    private String email;

    /**
     * 手机号
     */
    @Field("phone")
    private String phone;

    /**
     * 等级
     */
    @Field("level")
    private int level;

    /**
     * 金铢
     */
    @Field("gold")
    private int gold;

    /**
     * 玉璧
     */
    @Field("jades")
    private int jades;

    /**
     * 是否购买金卡
     */
    @Field("goldCard")
    private boolean goldCard;

    /**
     * 金卡有效期
     */
    @Field("goldDay")
    private int goldDay;

    /**
     * 是否购买银卡
     */
    @Field("silverCard")
    private boolean silverCard;

    /**
     * 银卡有效期
     */
    @Field("silverDay")
    private int silverDay;

    /**
     * 势力值
     */
    @Field("power")
    private int power;

    /**
     * 土地数
     */
    @Field("soil")
    private int soil;



}

