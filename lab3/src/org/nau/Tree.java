package org.nau;

import java.util.function.Function;

/**
 * Клас, що представляє дерево.
 */
public class Tree {
    /** Посилання на корінь дерева. */
    private Node root;

    /**
     * Видаляє елементи за певним критерієм.
     * @param function критерій для видалення елементів
     */
    public void deleteElements(Function<Student, Boolean> function) {
        if (root == null)
            return;
        //if () {
        //}
        //TODO
    }

    private void deleteElementsOfNode(Function<Student, Boolean> function, Node node) {
        if (node == null)
            return;
        if (node.getLeft() != null) {
            if (function.apply(node.getLeft().getData())) {
                node.setLeft(null);
            } else {
                deleteElementsOfNode(function, node.getLeft());
            }
        }
        if (node.getRight() != null) {
            if (function.apply(node.getRight().getData())) {
                node.setRight(null);
            } else {
                deleteElementsOfNode(function, node.getRight());
            }
        }
    }

    /**
     * Виведення всього дерева. Використовується алгоритм "обхід в ширину".
     * @return
     */
    public String toString() {
        if (root == null) {
            return "Empty tree.";
        }
        return showElementTree(root, 0);
    }

    /**
     * Виводить рядок з відображенням елементу дерева і всіх його дочірніх елементів.
     * @param currentNode
     * @param level
     * @return
     */
    private String showElementTree(Node currentNode, int level) {
        StringBuffer sb = new StringBuffer();
        if (currentNode == null)
            return "";
        for (int i = 0; i < level; i++) {
            sb.append("    ");
        }
        sb.append(currentNode.getData().toString());
        final int newLevel = level + 1;
        sb.append(showElementTree(currentNode.getLeft(), newLevel));
        sb.append(showElementTree(currentNode.getRight(), newLevel));
        return sb.toString();
    }

    /**
     * Додає новий елемент в дерево.
     * @param student студент
     * @return якщо вставка пройшла успішно, буде повернуто значення true
     */
    public boolean add(Student student) {
        //упаковка елемента в обгортку
        final Node node = new Node(student);
        if (root == null) {
            root = node;
            return true;
        } else {
            return add(node, root);
        }
    }

    /**
     * Додає новий елемент в дерево. Алгоритм наступний:
     * <ul>
     * <li>новый элемент (узел) всегда становится листом дерева</li>
     * <li>поиск позиции начинается с вершины дерева, постепенно смещаясь вниз</li>
     * <li>если значение нового узла меньше текущего, то переходим в левую ветку текущего узла</li>
     * <li>если левый узел у текущего отсутствует, то новый узел становится его левым узлом</li>
     * <li>если значения нового узла больше текущего, то переходим в правую ветку текущего узла</li>
     * <li>если правый узел у текущего отсутствует, то новый узел становится его правым узлом</li>
     * </ul>
     * @param newElem  елемент, який має бути додано в дерево
     * @param currElem елемент дерева, піделементом якого новий елемент буде
     * @return якщо вставка пройшла успішно, буде повернуто значення true
     */
    public boolean add(Node newElem, Node currElem) {
        if (newElem.getData().getStudentCard() == currElem.getData().getStudentCard()) {
            return false;
        }
        //если значение нового узла меньше текущего, то переходим в левую ветку текущего узла
        if (newElem.getData().getStudentCard() < currElem.getData().getStudentCard()) {
            //System.out.println("The value of the new element is less than the value of the current element.");
            final Node leftNode = currElem.getLeft();
            if (leftNode == null) {
                currElem.setLeft(newElem);
            } else {
                return add(newElem, leftNode);
            }
        } //если значения нового узла больше текущего, то переходим в правую ветку текущего узла
        else {
            final Node rightNode = currElem.getRight();
            //если правый узел у текущего отсутствует, то новый узел становится его правым узлом
            if (rightNode == null) {
                currElem.setRight(newElem);
            } else {
                return add(newElem, rightNode);
            }
        }
        return true;
    }
}
