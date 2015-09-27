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
     * @param aX
     * @param aY
     * @param bX
     * @param bY
     * @param cX
     * @param cY
     * @param dX
     * @param dY
     */
    public Rhombus(int aX, int aY, int bX, int bY, int cX, int cY, int dX, int dY) {
        a = new Vertex(aX, aY);
        b = new Vertex(bX, bY);
        c = new Vertex(cX, cY);
        d = new Vertex(dX, dY);
    }

    /**
     * Конструктор
     * @param vertex1 першиа вершина ромба
     * @param vertex2 друга вершина ромба
     * @param vertex3 третя вершина ромба
     * @param vertex4 четверта вершина ромба
     */
    public Rhombus(Vertex vertex1, Vertex vertex2, Vertex vertex3, Vertex vertex4) {
        this.a = vertex1;
        this.b = vertex2;
        this.c = vertex3;
        this.d = vertex4;
    }

    /**
     * Вираховує периметр ромбу.
     * @return
     */
    public double calculatePerimeter() {
        return distanceBetweenAandB() * 4;
    }

    /**
     * Метод розраховує відстань між точками А і Б.
     * @return
     */
    public double distanceBetweenAandB() {
        return calculateDistanceBetweenTwoPoints(a.getX(), a.getY(), b.getX(), b.getY());
    }

    /**
     * Розраховує площу ромба.
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

    /**
     * Генерує новий ромб
     * @return
     */
    public static Rhombus generateNewRhombus() {
        //Згенерувати дві точки
        //final Vertex vertex1 = new Vertex((int) java.lang.Math.random() % 100, (int) java.lang.Math.random() % 100);
        final Vertex vertex1 = new Vertex((int) (java.lang.Math.random() * 10), (int) (java.lang.Math.random() * 10));
        final Vertex vertex2 = new Vertex((int) (java.lang.Math.random() * 10), (int) (java.lang.Math.random() * 10));
        final Vertex vertex3 = new Vertex(vertex1.getX() + Math.abs((vertex1.getX() - vertex2.getX())) * 2, vertex1.getY());
        final Vertex vertex4 = new Vertex(vertex2.getX(), vertex2.getY() - Math.abs((vertex1.getY() - vertex2.getY()) * 2));
        return new Rhombus(vertex1, vertex2, vertex3, vertex4);
    }

    @Override
    public String toString() {
        return "vertex1: " + a + "\n vertex2: " + b + "\n vertex3: " + c + "\n vertex4: " + d;
    }
}