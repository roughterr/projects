package org.nau;

/**
 * This class implements a queue that contains an array of unsigned integer numbers.
 */
public class VectorQueue implements VectorDataStructureIntf {
    private int[] numbersArray;

    /**
     * The size of the array.
     */
    private int size;

    public VectorQueue() {
        size = 0;
    }

    /**
     * Returns true when the array is full, otherwise returns false.
     * @return
     */
    public boolean isFull() {
        //TODO
        return false;
    }

    /**
     * Returns true when the array is empty, otherwise returns false.
     * @return
     */
    public boolean isEmpty() {
        //TODO
        return false;
    }
}
