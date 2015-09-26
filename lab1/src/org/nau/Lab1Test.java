package org.nau;

/**
 * Тестування першої лаби. Варіант №18.
 */
public class Lab1Test {
    public static void main(String[] args) throws Exception {
        //створити екземпляри описаних структур даних
        //створення структури даних з векторним способом розміщення елементів у пам’яті
        Queue queue = new Queue();
        //створення структури даних зі зв’язаним способом розміщення елементів у пам’яті
        DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();
        System.out.println("Empty list: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(17);
        System.out.println("After adding 17: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(12);
        System.out.println("After adding 12: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(-15);
        System.out.println("After adding -15: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(123);
        System.out.println("After adding 123: " + doublyLinkedList1);
        //видалити усі від’ємні елементи
        doublyLinkedList1.deleteElements(val -> val < 0);
        System.out.println("After deletion all the negative numbers: " + doublyLinkedList1);
    }

    /**
     * Тестування черги з цілими беззнаковими елементами. В main-метод не включено, бо таке тестування не передбачено
     * в завданні.
     *
     * @throws Exception
     */
    @Deprecated
    public void testAddingElementsToQueue() throws Exception {
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
        //видалення одного елемента з черги
        queue.deleteOldestElement();
        System.out.println("After deletion of one element from the queue: " + queue);
    }
}
