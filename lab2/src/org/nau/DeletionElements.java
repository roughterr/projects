package org.nau;

import java.util.function.Function;

/**
 * Містить метод для видалення тих елементів із хеш-таблиці, в яких площа менша заданої.
 */
public class DeletionElements {
    /**
     * Видаляє елементи із хеш-таблиці
     * @param area
     * @param hashtable
     */
    public <K> void deleteElementsWithSmallerArea(double area, NAUHashtable<K, Rhombus> hashtable) {
        hashtable.remove(entry -> entry.getValue().calcuateArea() < area);
    }
}
