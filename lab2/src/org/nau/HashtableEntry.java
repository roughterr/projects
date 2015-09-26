package org.nau;

/**
 * Даний клас представляє елемент хеш-таблиці.
 */
public class HashtableEntry {
    /**
     * Ключ елемента хеш-таблиці.
     */
    private final int key;
    /**
     * Значення елемента хеш-таблиці.
     */
    private final Rhombus value;

    /**
     * Конструктор.
     *
     * @param key   ключ елемента хеш-таблиці
     * @param value значення елемента хеш-таблиці
     */
    public HashtableEntry(int key, Rhombus value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Повертає ключ елемента хеш-таблиці.
     *
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * Повертає значення елемента хеш-таблиці.
     *
     * @return
     */
    public Rhombus getValue() {
        return value;
    }
}
