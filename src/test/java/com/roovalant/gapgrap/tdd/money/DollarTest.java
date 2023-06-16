package com.roovalant.gapgrap.tdd.money;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DollarTest {

//    @Autowired
//    Dollar dollar;

    @Test
    public void testMultiplication() {
        /**
         * 1. Dollar 클래스가 없음
         * 2. Dollar 생성자가 없음
         * 3. times(int) 메서드가 없음
         * 4. amount 필드가 없음
         */
//        Dollar five = new Dollar(5);
//        five.times(2);
//        assertEquals(10, five.amount); // 여기서 amount 가 10 이 됨!
//        five.times(3);
//        assertEquals(15, five.amount); // 위의 10 에서 * 3 이 되니까 30 이 나옴!

        /**
         * 하나의 Dollar 객체에 곱하기를 두번 수행할 수 있게 하기
         */
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
    }
}
