package org.nau;

/**
 * Тестування першої лаби. Варіант №18.
 */
public class Lab1Test {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();
        System.out.println("Before adding any elements: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(17);
        System.out.println("After adding 17: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(12);
        System.out.println("After adding 12: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(-15);
        System.out.println("After adding -15: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(123);
        System.out.println("After adding 123: " + doublyLinkedList1);
    }
}
