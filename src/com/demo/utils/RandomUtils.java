package com.demo.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static boolean probability(double p) {
        return p >= 1 || ThreadLocalRandom.current().nextDouble(0, 1) >= (1 - p);
    }

    public static void main(String[] arg) {
        int t = 0;
        int f = 0;
        int i = 0;
        while (i++ < 1000000) {
            if (RandomUtils.probability(0.41)) {
                t++;
            } else {
                f++;
            }
        }
        System.out.println("t=" + t + ",f=" + f);
    }
}
