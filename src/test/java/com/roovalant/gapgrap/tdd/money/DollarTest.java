package com.roovalant.gapgrap.tdd.money;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount); // five.amount 는 0이 나옴
    }
}
