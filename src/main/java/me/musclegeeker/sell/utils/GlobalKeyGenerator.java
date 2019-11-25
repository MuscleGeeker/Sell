package me.musclegeeker.sell.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GlobalKeyGenerator {

    /**
     * 生成唯一字符串
     *
     * @return
     */
    public static synchronized String genUniqueKey() {
        String randomString = RandomStringUtils.randomNumeric(6);

        return System.currentTimeMillis() + randomString;
    }
}
