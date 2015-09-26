package org.nau;

/**
 * Ромб: координати вершин, конструктор, методи обчислення площини, периметру, виведення об'єкта.
 */
public class Rhombus {
    /**
     * Вершина A.
     */
    private Vertex a;
    /**
     * Вершина B.
     */
    private Vertex b;
    /**
     * Вершина C.
     */
    private Vertex c;
    /**
     * Вершина D.
     */
    private Vertex d;

    /**
     * Конструктор.
     *
     * @param aX
     * @param aY
     * @param bX
     * @param bY
     * @param cX
     * @param cY
     * @param dX
     * @param dY
     */
    @Deprecated
    public Rhombus(int aX, int aY, int bX, int bY, int cX, int cY, int dX, int dY) {
        a = new Vertex(aX, aY);
        b = new Vertex(bX, bY);
        c = new Vertex(cX, cY);
        d = new Vertex(dX, dY);
    }

    /**
     * Вираховує периметр ромбу.
     *
     * @return
     */
    public double calculatePerimeter() {
        return distanceBetweenAandB() * 4;
    }

    /**
     * Метод розраховує відстань між точками А і Б.
     *
     * @return
     */
    public double distanceBetweenAandB() {
        return calculateDistanceBetweenTwoPoints(a.getX(), a.getY(), b.getX(), b.getY());
    }

    /**
     * Розраховує площу ромба.
     *
     * @return
     */
    public double calcuateArea() {
        final double diagonalAC = calculateDistanceBetweenTwoPoints(a.getX(), a.getY(), c.getX(), c.getY());
        final double diagonalBD = calculateDistanceBetweenTwoPoints(b.getX(), b.getY(), d.getX(), d.getY());
        System.out.println("diagonalAC='" + diagonalAC + "', diagonalBD='" + diagonalBD + "'.");
        return (double) (diagonalAC * diagonalBD) / 2.0;
    }

    /**
     * Розраховує відстань між двома точками, які задані координатами.
     *
     * @param aX
     * @param aY
     * @param bX
     * @param bY
     * @return
     */
    public static double calculateDistanceBetweenTwoPoints(int aX, int aY, int bX, int bY) {
        final int var1 = bX - aX;
        final int var2 = bY - aY;
        final double var3 = (var1 * var1) + (var2 * var2);
        return Math.sqrt(var3);
    }
}
