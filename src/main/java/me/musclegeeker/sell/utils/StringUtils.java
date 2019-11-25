package me.musclegeeker.sell.utils;

import java.util.UUID;

/**
 * 字符串工具类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 生成UUID
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
