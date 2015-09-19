package org.nau;

import java.util.Optional;

/**
 * Двоспрямований список. Цілий.
 */
public class DoublyLinkedList {
    /**
     * Перший елемент двоспрямованого списку.
     */
    private final DoublyLinkedListElement firstNode;
    //    /**
    //     * Останній елемент двоспрямованого списку
    //     */
    //    private DoublyLinkedListElement lastNode;
    //
    //    /**
    //     * Конструктор.
    //     *
    //     * @param firstNode перший елемент двоспрямованого списку
    //     * @param lastNode  останній елемент двоспрямованого списку
    //     */
    //    public DoublyLinkedList(DoublyLinkedListElement firstNode, DoublyLinkedListElement lastNode) {
    //        this.firstNode = firstNode;
    //        this.lastNode = lastNode;
    //    }

    /**
     * Конструктор.
     *
     * @param firstNode перший елемент двоспрямованого списку
     */
    public DoublyLinkedList(DoublyLinkedListElement firstNode) {
        this.firstNode = firstNode;
    }

    /**
     * Повертає перший елемент списку.
     *
     * @return
     */
    public DoublyLinkedListElement getFirstNode() {
        return firstNode;
    }

    /**
     * Видадяє елементу зі списку.
     *
     * @param val значення елементу, який підлягає видаленню
     * @return спискок із відсутніми видаленими елементами
     */
    private DoublyLinkedList deleteNode(int val) {
//        if (isEmpty()) {
//            return this;
//        }
//        while (true) {
//            //Якщо підлягає видаленню
//            if (getFirstNode().getValue() == val) {
//                return deleteNode(new DoublyLinkedList(this.getFirstNode().getNextElement()));
//            } else {//Якщо не підлягає видаленню
//                //Якщо немає наступного елементу.
//                if (getFirstNode().isThereNextElement()) {
//                    //достаємо другий елемент
//                    final DoublyLinkedListElement secondElement = getFirstNode().getNextElement();
//                    return new DoublyLinkedList(secondElement).deleteNode(val);
//                } else {
//                    return this;
//                }
//            }
//        }
        //TODO
        return null;
    }

    /**
     * Перевіряє порожність структури даних (чи дорівнює значенню null посилання на елемент, за допомогою якого
     * виконується обробка структури даних) та викликається в операції видалення для запобігання отриманню елемента з
     * порожньої структури даних.
     *
     * @return
     */
    public boolean isEmpty() {
        //TODO
        return true;
    }
}
