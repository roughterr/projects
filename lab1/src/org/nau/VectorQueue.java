package org.nau;

/**
 * This class implements a queue that contains an array of unsigned integer numbers.
 */
public class VectorQueue implements VectorDataStructureIntf {
    private int[] array;

    /**
     * Індекс останнього елементу в черзі.
     */
    private int indexOfHead = -1;

    /**
     * Індекс першого елементу в черзі.
     */
    private int indexOfTail = -1;

    public VectorQueue() {
    }

    public boolean isFull() {
        boolean result =
                array.length == indexOfHead + 1;
        System.out.println("isFull() returns " + result + ".");
        return result;
    }

    public boolean isEmpty() {
        //TODO
        return false;
    }

    /**
     * Перестворює масив. Якщо потрібно, то збільшує розмір.
     */
    private void recreateArray() {
        System.out.println("recreateArray() called.");
        //кількість резервних комірок
        int reserve = 10;
        //кількість використаних комірок в поточному масиві
        int currentNumberElements = indexOfHead - indexOfTail;
        //новий розмір масиву
        int newSize = currentNumberElements + reserve;
        //створення об’єкту нового масиву
        int[] newArray = new int[newSize];
        //індекс першого вільної комірки в новому масиві
        int newArrayIndex = -1;
        //перекидування елементів зі старого масиву в новий
        for (int i = indexOfTail; i <= indexOfHead; i++) {
            newArrayIndex++;
            newArray[newArrayIndex] = array[i];
        }
        //оновлення змінних класу
        indexOfHead = currentNumberElements - 1;
        indexOfTail = 0;//TODO
        array = newArray;
    }

    /**
     * Додає новий елемент в чергу.
     *
     * @param elementToAdd елемент, який має бути додано
     */
    public void add(int elementToAdd) {
        //якщо масив переповнений, то потрібно збільшити місткість масиву
        if (isFull()) {
            recreateArray();
            //рекурсія
            add(elementToAdd);
        } else {
            indexOfHead++;
            array[indexOfHead] = elementToAdd;
        }
    }
}
