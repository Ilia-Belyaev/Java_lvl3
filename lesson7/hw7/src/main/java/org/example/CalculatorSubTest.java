package org.example;

import org.junit.jupiter.api.*;

class CalculatorSubTest {
    private CalculatorSub calculatorSub;
    @BeforeEach
    public void init() {
        calculatorSub = new CalculatorSub();
    }
    @Test
    void sub() {
        Assertions.assertEquals(3, calculatorSub.sub(5, 2));
    }
    @Test
    void sub1() {
        Assertions.assertEquals(8, calculatorSub.sub(5, 2));
    }
    @Test
    void sub2() {
        Assertions.assertEquals(-5, calculatorSub.sub(3, 8));
    }
    @AfterAll
    static void ending(){
        System.out.println("org.example.Test complete");
    }
}