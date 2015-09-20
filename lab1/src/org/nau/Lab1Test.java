package org.nau;

/**
 * Тестування першої лаби. Варіант №18.
 */
public class Lab1Test {
    public static void main(String[] args) {
        //створення структури даних з векторним способом розміщення елементів у пам’яті
        Queue queue = new Queue();
        System.out.println("Empty queue: " + queue);
        queue.add(45);
        System.out.println("Queue after adding 45: " + queue);
        queue.add(31);
        System.out.println("Queue after adding 31: " + queue);
        for (int i = 0; i < 10; i++) {
            int numberToInsert = i * 4;
            queue.add(numberToInsert);
            System.out.println("Queue after adding '" + numberToInsert + "': " + queue);
        }
        //створення структури даних зі зв’язаним способом розміщення елементів у пам’яті
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
        //видалити усі від’ємні елементи
        doublyLinkedList1.deleteElements(new IntConditionIntf() {
            public boolean isConditionSatisfied(int val) {
                return val < 0;
            }
        });
        System.out.println("After deletion all the negative numbers: " + doublyLinkedList1);
    }
}
