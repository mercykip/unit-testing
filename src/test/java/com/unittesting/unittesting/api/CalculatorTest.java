package com.unittesting.unittesting.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator cal = new Calculator();
    int a = 10;
    int b = 5;

    @Test
    void add() {
        assertEquals(cal.add(a, b), 15);
    }

    @Test
    void sub() {
        assertEquals(cal.sub(a, b), 5);
    }

    @Test
    void mul() {
        assertEquals(cal.mul(a, b), 50);
    }

    @Test
    void div() {
        assertEquals(cal.div(a, b), 2);
    }
}