package org.nau;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестування для лаби №2. Варіант 18.
 */
public class Lab2Test {
    /**
     * Тестує метод, який видаляє елементи із хеш-таблиці.
     */
    @Test
    public void testDeletion() {
        //створити 5 ромбів
        final Rhombus rhombus1 = new Rhombus(8, 0, 5, 3, 8, 6, 11, 3);//should not be deleted
        //вивести ромб на екран
        //System.out.println(PrintRhombus.makeStringWithRhombusPicture(rhombus1));
        final Rhombus rhombus2 = new Rhombus(1, 0, 0, 1, 1, 2, 2, 1);//should be deleted
        //System.out.println(PrintRhombus.makeStringWithRhombusPicture(rhombus2));
        final Rhombus rhombus3 = new Rhombus(0, -1, -2, -3, -4, -1, -2, 1);
        //System.out.println(PrintRhombus.makeStringWithRhombusPicture(rhombus3));
        final Rhombus rhombus4 = new Rhombus(0, -1, -8, 0, 0, 1, 8, 0);
        //System.out.println(PrintRhombus.makeStringWithRhombusPicture(rhombus4));
        final Rhombus rhombus5 = new Rhombus(3, 2, 1, 4, 3, 6, 5, 4);
        //System.out.println(PrintRhombus.makeStringWithRhombusPicture(rhombus5));
        //додати ромби в хеш-таблицю
        NAUHashtable<Double, Rhombus> table = new NAUHashtable<>();
        table.put(rhombus1.calculatePerimeter(), rhombus1);
        table.put(rhombus2.calculatePerimeter(), rhombus2);
        table.put(rhombus3.calculatePerimeter(), rhombus3);
        table.put(rhombus4.calculatePerimeter(), rhombus4);
        table.put(rhombus5.calculatePerimeter(), rhombus5);
        //видалення
        System.out.println("Before deleting: " + table);
        DeletionElements.deleteElementsWithSmallerArea(10000, table);
        System.out.println("Remaining elements: " + table);
    }

    @Test
    public void testHashtable() {
        //Створення нової колекції.
        NAUHashtable<Double, Rhombus> table = new NAUHashtable<>();
        final Rhombus rhombus1 = new Rhombus(1, 1, 1, 5, 5, 5, 5, 1);
        table.put(rhombus1.calculatePerimeter(), rhombus1);
        System.out.println("table after adding the first rhombus: " + table);
        final Rhombus rhombus2 = new Rhombus(0, 0, 0, 0, 0, 0, 0, 0);
        table.put(rhombus2.calculatePerimeter(), rhombus2);
        System.out.println("table after adding the second rhombus: " + table);
    }

    /**
     * В цьому тесті перевіряється, що метод по генерації ромбів генерації генерує правильні ромби.
     * Ця перевірка виконується за рахунок перевірки відстаней від вершин. Усі чотири сторони мають мати однакову
     * довжину. Якщо вони різної довжини, то це значить, що метод генерує неправильні ромби.
     */
    @Test
    public void testGenerateNewRhombus() {
        Rhombus rhombus1 = Rhombus.generateNewRhombus();
        final double ab = Rhombus.calculateDistanceBetweenTwoPoints(rhombus1.getVertexA().getX(),
                rhombus1.getVertexA().getY(), rhombus1.getVertexB().getX(), rhombus1.getVertexB().getY());
        final double bc = Rhombus.calculateDistanceBetweenTwoPoints(rhombus1.getVertexB().getX(),
                rhombus1.getVertexB().getY(), rhombus1.getVertexC().getX(), rhombus1.getVertexC().getY());
        final double cd = Rhombus.calculateDistanceBetweenTwoPoints(rhombus1.getVertexC().getX(),
                rhombus1.getVertexC().getY(), rhombus1.getVertexD().getX(), rhombus1.getVertexD().getY());
        final double da = Rhombus.calculateDistanceBetweenTwoPoints(rhombus1.getVertexD().getX(),
                rhombus1.getVertexD().getY(), rhombus1.getVertexA().getX(), rhombus1.getVertexA().getY());
        assertEquals(ab, bc, 0.001);
        assertEquals(bc, cd, 0.001);
        assertEquals(cd, da, 0.001);
    }

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
        assertEquals(1.0, area, 0.001);
    }

    @Test
    public void testMethodCalcAreaRhombus2() {
        final Rhombus rhombus = new Rhombus(-2, -2, -2, -1, -1, -1, -1, -2);
        final double area = rhombus.calcuateArea();
        assertEquals(1.0, area, 0.001);
    }

    @Test
    public void testMethodCalcAreaRhombus3() {
        final Rhombus rhombus = new Rhombus(0, 0, 3, 2, 6, 0, 3, -2);
        final double area = rhombus.calcuateArea();
        assertEquals(12.0, area, 0.001);
    }
}
