package org.nau;

import java.util.Hashtable;

/**
 * Хеш-таблиця.
 *
 * @param <K> тип ключа
 * @param <V> тип значення
 */
public class NAUHashtable<K, V> {
    /**
     * Тут зберігатимуться елементи хеш-тиблиці. Створення представлення для запису, а не рознесено на окремі два масиви
     * через те, що в Джава не можна створити масив типу дженерік.
     */
    private HashtableEntry<K, V>[] table;

    /**
     * Розмір хеш-таблиці за замовчуванням.
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Розмір хеш-таблиці.
     */
    private int size;

    public NAUHashtable() {
        table = new HashtableEntry[DEFAULT_SIZE];
    }

    /**
     * Розраховує індекс елементу якщо відомий хеш-код ключа елементу.
     *
     * @param hashcode хеш-код ключа елементу
     * @return
     */
    public int calcIndexByHashcode(int hashcode) {
        int calcuatedIndex = (hashcode & 0x7FFFFFFF) % table.length;
        System.out.println("calcuatedIndex='" + calcuatedIndex + "'.");
        return calcuatedIndex;
    }

    /**
     * Вставляє елемент в хеш-таблицю.
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        final int indexOfExisting = findExistingElement(key);
        System.out.println("indexOfExisting='" + indexOfExisting + "'.");
        final int indexToPush;
        if (indexOfExisting == -1) {
            //Знайти найближчу вільну комірку.
            final int indexOfEmpty = findAvailableRoomForEntry(key);
            if (indexOfEmpty == -1)
                throw new NoFreeCellsException();
            indexToPush = indexOfEmpty;
        } else {
            indexToPush = indexOfExisting;
        }
        table[indexToPush] = new HashtableEntry<>(key, value);
    }

    /**
     * Інкапсулює хешкод з можливістю згенерувати інший хеш-код для того самого ключа,
     * з метою реалізації квадратичного зонування (Quadratic Probing).
     */
    private static class HashCodeToProbe {
        private final int hashcode;
        private final int h;

        public HashCodeToProbe(int hashcode) {
            this.hashcode = hashcode;
            this.h = 1;
        }

        private HashCodeToProbe(int hashcode, int h) {
            this.hashcode = hashcode;
            this.h = h;
        }

        public HashCodeToProbe next() {
            final int newH = h + 1;
            return new HashCodeToProbe(hashcode + (newH * newH), newH);
        }

        public int getHashcode() {
            return hashcode;
        }

        public int getH() {
            return h;
        }
    }


    /**
     * Визначає індекс елементу з заданим ключем. Використовує квадратичне зонування до того моменту, поки не знайде
     * елемент.
     *
     * @param key значення ключа елементу
     * @return індекс. Якщо елемента не знайдено, то повернення
     */
    public int calcIndexOfElementWithProbing(K key) {
        HashCodeToProbe hashCodeToProbe = new HashCodeToProbe(key.hashCode());
        while (true) {
            int index = calcIndexByHashcode(hashCodeToProbe.getHashcode());
            K keyByIndex = table[index].getKey();
            if (keyByIndex == null) {

            }
        }
    }

    /**
     * Здійснює пошук елементу в хеш-таблиці.
     *
     * @param key ключ елементу
     * @return індекс елементу. Якщо елемента не знайдено, то повернення значення -1
     */
    public int findExistingElement(K key) {
        HashCodeToProbe hashCodeToProbe = new HashCodeToProbe(key.hashCode());
        while (hashCodeToProbe.getH() < table.length) {
            final int index = calcIndexByHashcode(hashCodeToProbe.getHashcode());
            HashtableEntry<K, V> element = table[index];
            if (element != null && key.equals(element.getKey())) {
                return index;
            }
            hashCodeToProbe = hashCodeToProbe.next();
        }
        return -1;
    }

    /**
     * Знаходить вільну комірку для нового елементу.
     *
     * @param key ключ елементу
     * @return індекс вільної комірки. Якщо вільної комірки не знайдено, то повернення значення -1
     */
    private int findAvailableRoomForEntry(K key) {
        HashCodeToProbe hashCodeToProbe = new HashCodeToProbe(key.hashCode());
        while (hashCodeToProbe.getH() < table.length) {
            final int index = calcIndexByHashcode(hashCodeToProbe.getHashcode());
            HashtableEntry<K, V> element = table[index];
            if (element == null)
                return index;
        }
        return -1;
    }

    /**
     * Отримує значення елементу хеш-таблиці.
     *
     * @param key ключ
     * @return значення
     */
    public V get(K key) {
        int index = findExistingElement(key);
        return index == -1 ? null : table[index].getValue();
    }

    /**
     * Виводить інформацію про хеш-таблицю.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append("The cell #" + i + " is empty.\n");
            } else {
                sb.append("The cell #" + i + " has key '" + table[i].getKey() + "' and value '" + table[i].getValue() + "'.\n");
            }
        }
        return sb.toString();
    }
}
