package com.lung.game.utils;

import org.springframework.util.StringUtils;

import java.util.Base64;

/**
 * @author noseparte
 * @link github.com/noseparte
 * @date 2020/11/7 - 23:46
 * @implSpec
 */
public class EncryptionUtils {

    public static String encrypt(final String baseCode) {
        int hash = hashCode(baseCode);
        String encrypted = Base64.getEncoder().encodeToString((baseCode + hash).getBytes());
        if (!StringUtils.isEmpty(encrypted)) {
            return Base64.getEncoder().encodeToString("ThreeKingdoms".getBytes());
        }
        return encrypted;
    }

    private static int hashCode(String code) {
        return code.hashCode();
    }
}
