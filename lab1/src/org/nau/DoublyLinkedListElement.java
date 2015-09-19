package org.nau;

import java.util.Optional;

/**
 * Даний клас представляє один елемент двоспрямованого списку. Він містить посилання на попередній і наступний елементи,
 * а також саме значення елементу.
 */
public class DoublyLinkedListElement {
    /**
     * Попередній елемент.
     */
    private final Optional<DoublyLinkedListElement> previousElement;

    /**
     * Наступний елемент.
     */
    private final Optional<DoublyLinkedListElement> nextElement;

    /**
     * Значення поточного елементу.
     */
    private final int currentElement;

    /**
     * Конструктор.
     */
    public DoublyLinkedListElement(Optional<DoublyLinkedListElement> previousElement,
                                   Optional<DoublyLinkedListElement> nextElement,
                                   int currentElement) {
        this.previousElement = previousElement;
        this.nextElement = nextElement;
        this.currentElement = currentElement;
    }

    /**
     * Показує чи є посилання на попередній елемент.
     */
    public boolean isTherePreviousElement() {
        return previousElement.isPresent();
    }

    /**
     * Показує чи є посилання на наступний елемент.
     */
    public boolean isThereNextElement() {
        return nextElement.isPresent();
    }

    /**
     * Повертає попередній елемент.
     *
     * @return
     */
    public DoublyLinkedListElement getPreviousElement() {
        return previousElement.get();
    }

    /**
     * Повертає наступний елемент.
     *
     * @return
     */
    public DoublyLinkedListElement getNextElement() {
        return nextElement.get();
    }

    /**
     * Повертає значення поточного елементу.
     *
     * @return
     */
    public int getValue() {
        return currentElement;
    }

    /**
     * Видаляє усі елементи з певним значенням, після поточного елементу, тобто далі.
     *
     * @param val
     * @return
     */
    public DoublyLinkedListElement deleteNextElementsWithValue(int val) {
        if (currentElement == val) {
            //rebuild the next element
            new DoublyLinkedListElement(previousElement, null, 1);
        } else {
            if (nextElement.isPresent()) {
                new DoublyLinkedListElement(previousElement,
                        Optional.of(nextElement.get().deleteNextElementsWithValue(val)), currentElement);
            } else {
                return this;
            }
        }
        return null;
    }

    /**
     * Змінює наступний елемент. А в наступному елементі змінює попередній елемент на цей.
     *
     * @return
     */
    public DoublyLinkedListElement changeNextElement(DoublyLinkedListElement newNextElement) {
        //rebuild the next element
        final DoublyLinkedListElement newNextElementRebuilt =
                new DoublyLinkedListElement(Optional.of(this), null, newNextElement.getValue());
        return null;
    }

//    /**
//     * Змінює попередній елемент.
//     *
//     * @param newPreviousElement
//     * @return
//     */
//    public DoublyLinkedListElement changePreviousElement(DoublyLinkedListElement newPreviousElement) {
//        Optional.of();
//        return new DoublyLinkedListElement(newPreviousElement.changeNextElement(null), nextElement, currentElement);
//    }
}
