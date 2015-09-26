package org.nau;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестування для лаби №2. Варіант 18.
 */
public class Lab2Test {
    /**
     * Тестує метод, який вимірює відстань між двома точнами.
     */
    @Test
    public void testMethodCalcDistanceBetweenPoints() {
        final Rhombus rhombus = new Rhombus(1, 1, 1, 5, 5, 5, 5, 1);
        final double distance = rhombus.distanceBetweenAandB();
        assertEquals(4.0, distance, 0.001);
    }

    /**
     * Тестує метод, який вимірює площу ромба, в якого всі координати - нулі.
     */
    @Test
    public void testMethodCalcAreaZeroRhombus() {
        final Rhombus rhombus = new Rhombus(0, 0, 0, 0, 0, 0, 0, 0);
        final double area = rhombus.calcuateArea();
        assertEquals(0.0, area, 0.001);
    }

    @Test
    public void testMethodCalcAreaRhombus1() {
        final Rhombus rhombus = new Rhombus(3, 4, 4, 4, 4, 3, 3, 3);
        final double area = rhombus.calcuateArea();
        assertEquals(1.0, area, 0);
    }

    @Test
    public void testMethodCalcAreaRhombus2() {
        final Rhombus rhombus = new Rhombus(-2, -2, -2, -1, -1, -1, -1, -2);
        final double area = rhombus.calcuateArea();
        assertEquals(1.0, area, 0);
    }

    @Test
    public void testMethodCalcAreaRhombus3() {
        final Rhombus rhombus = new Rhombus(0, 0, 3, 2, 6, 0, 3, -2);
        final double area = rhombus.calcuateArea();
        assertEquals(12.0, area, 0);
    }
}
