package com.roovalant.gapgrap.tdd.money;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
//        assertEquals(10, product.amount); // Dollar 클래스의 amount 접근제어자를 private 로 바꿔서 에러남
        product = five.times(3);
//        assertEquals(15, product.amount); // Dollar 클래스의 amount 접근제어자를 private 로 바꿔서 에러남

        /**
         * 위의 코드를, Dollar 와 Dollar 끼리 비교할 수 있게 코드 변경하기
         */
        Dollar five2 = new Dollar(5);
        assertEquals(new Dollar(10), five2.times(2));
        assertEquals(new Dollar(15), five2.times(3));
    }

    @Test
    public void testEquality() {
        // Dollar 끼리 비교하기
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        // Franc 끼리 비교하기
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
        // Dollar 와 Franc 비교하기
        assertFalse(new Franc(5).equals(new Dollar(5))); // False 가 나와야하는데 true 가 나온다
    }

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}
