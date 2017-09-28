package com.demo;

import com.demo.utils.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GamblingTest {

    public static void main(String[] arg) {
        BigDecimal money = new BigDecimal("10000");
        int i = 0;
        while (i++ < 10) {
            if (RandomUtils.probability(0.5)) {
                money = money.add(money.divide(new BigDecimal("2"), RoundingMode.HALF_UP));
            } else {
                money = money.subtract(money.divide(new BigDecimal("2"),RoundingMode.HALF_UP));
            }
        }
        System.out.println(money);
    }
}
