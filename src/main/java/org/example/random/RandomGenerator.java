package org.example.random;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomGenerator {
    public static String getRandom() {
        String random = RandomStringUtils.randomAlphabetic(6);
        return random;
    }
}
