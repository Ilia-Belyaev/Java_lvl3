package org.example;

import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
//import org.junit.jupiter.api.BeforeEach;


public class CalculatorDivTest {
    private static CalculatorDiv calculatorDiv;

    @BeforeEach
    static void init() {
        calculatorDiv = new CalculatorDiv();
        System.out.println("init");
    }

    //    @BeforeEach
//    static void init1() {
//        calculatorDiv = new CalculatorDiv();
//        System.out.println("init1");
//    }
    @Test(priority = 1)
    static void div() {
        Assertions.assertEquals(107, calculatorDiv.div(214, 2));
        System.out.println("1");
    }

    @Test(priority = 4)
    static void div1() {
        Assertions.assertEquals(2, calculatorDiv.div(5, 2));
        System.out.println("4");
    }

    @Test(priority = 7)
    static void div2() {
        Assertions.assertEquals(1, calculatorDiv.div(2, 2));
        System.out.println("7");
    }

    @Test(priority = 3)
    static void div4() {
        Assertions.assertEquals(2, calculatorDiv.div(4, 2));
        System.out.println("3");
    }

    @AfterAll
    static void ending() {
        System.out.println("Test complete");
    }
//    @AfterAll
//    static void ending1() {
//        System.out.println("Test complete 1");
//    }
}