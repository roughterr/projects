package org.nau;

/**
 * адаптер.
 */
public class DoublyLinkedList {
    /**
     * Перший елемент списку.
     */
    private Node firstNode;

    public DoublyLinkedList() {
    }

    /**
     * Видаляє усі елементи списку, які містять вказане значення.
     *
     * @val
     */
    public void deleteElementsWithValue(int val) {
        Node firstNormalNode = null;
        Node currNode = firstNode;
        while (currNode != null) {
            if (currNode.getVal() == val) {
                //fix the previous element
                if (currNode.getPreviousNode() != null) {
                    currNode.getPreviousNode().setNextNode(currNode.getNextNode());
                }
                //fix the next element
                if (currNode.getNextNode() != null) {
                    currNode.getNextNode().setPreviousNode(currNode.getPreviousNode());
                }
            } else {
                if (firstNormalNode == null) {
                    firstNormalNode = currNode;
                }
            }
            currNode = currNode.getNextNode();
        }
        firstNode = firstNormalNode;
    }

    /**
     * перевіряє порожність структури даних (чи дорівнює значенню null посилання на елемент, за допомогою якого
     * виконується обробка структури даних) та викликається в операції видалення для запобігання отриманню елемента з
     * порожньої структури даних.
     *
     * @return
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    /**
     * Додає новий елемент в початок списку.
     *
     * @param val
     * @return true - вставка пройшла успішно
     */
    public boolean addElementToHead(int val) {
        Node newFirstNode = new Node(val);
        if (!isEmpty()) {
            //для нової ноди наступною нодою буде та нода, яка на даний момент є першою нодою
            newFirstNode.setNextNode(firstNode);
            //для тої ноди, яка зараз є першою нодою, зміни попередньої ноди
            firstNode.setPreviousNode(newFirstNode);
        }
        //виправляє поточний перший елемент
        firstNode = newFirstNode;
        return true;
    }

    /**
     * Повертає хвіст списку.
     *
     * @return
     */
    public Node getTail() {
        Node currNode = firstNode;
        while (true) {
            if (currNode == null) {
                return null;
            }
            if (currNode.getNextNode() == null) {
                return currNode;
            }
            currNode = currNode.getNextNode();
        }
    }

    /**
     * Додає новий елемент в кінець списку.
     *
     * @param val
     * @return true - вставка пройшла успішно
     */
    public boolean addElementToTail(int val) {
        Node newLastNode = new Node(val);
        if (isEmpty()) {
            firstNode = newLastNode;
        } else {
            Node tail = getTail();
            tail.setNextNode(newLastNode);
            newLastNode.setPreviousNode(tail);
        }
        return true;
    }
}