package ru.vsu.cs.course1.tree.bst;

import ru.vsu.cs.course1.tree.DefaultBinaryTree;

/**
 * Интерфейс для двоичного дерева поиска (BinarySearchTree) с реализацией по
 * умолчанию многих типичных для таких деревьев методов
 *
 * @param <T>
 */
public interface DefaultBSTree<T extends Comparable<? super T>> extends DefaultBinaryTree<T> {

    /**
     * Поиск TreeNode по значению в поддереве node
     *
     * @param node Узел дерева
     * @param value Значение для поиска
     * @return Узел, содержащий искомый элемент
     */
    default DefaultBinaryTree.TreeNode<T> getNode(DefaultBinaryTree.TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = node.getValue().compareTo(value);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return getNode(node.getLeft(), value);
        } else {
            return getNode(node.getRight(), value);
        }
    }

    /*
      Реализации без рекурсии (для сравнения)

     default DefaultBinaryTree.TreeNode<T> getNode(DefaultBinaryTree.TreeNode<T> node, T value) {
        while (node != null) {
            int cmp = node.getValue().compareTo(value);
            if (cmp == 0) {
                break;
            } else if (cmp > 0) {
                return node = node.getLeft();
            } else {
                return node = node.getRight();
            }
        }
        return node;
    }

     */

    /**
     * Поиск TreeNode по значению
     *
     * @param value Значение для поиска
     * @return Узел, содержащий искомый элемент
     */
    default DefaultBinaryTree.TreeNode<T> getNode(T value) {
        return getNode(getRoot(), value);
    }

    /**
     * Поиск знаяения, равного значению (не обязательного того же самого)
     *
     * @param value Значение для поиска
     * @return Искомое значение
     */
    default T get(T value) {
        DefaultBinaryTree.TreeNode<T> valueNode = getNode(value);
        return (valueNode == null) ? null : valueNode.getValue();
    }

    /**
     * Проверка, содержится ли значение value (или равное value) в дереве
     *
     * @param value Значение для поиска
     * @return true/false
     */
    default boolean contains(T value) {
        return getNode(value) != null;
    }

    /**
     * Добавление элемента в дерево (возвращать старое значение нажно для
     * эффективной реализации словаря Map из стандартной библиотеки)
     *
     * @param value Добавляемое значение
     * @return Старое значение, равное value, если было
     */
    T put(T value);

    /**
     * Удаление значения из дерева (возвращать старое значение нажно для
     * эффективной реализации словаря Map из стандартной библиотеки)
     *
     * @param value Удаляемое значение
     * @return Старое значение, равное value, если было
     */
    T remove(T value);

    /**
     * Очистка дерева (удаление всех элементов)
     */
    void clear();

    /**
     * Размер дерева
     *
     * @return Кол-во элементов в дереве
     */
    int size();

    /**
     * Поиск минимального TreeNode в поддереве node
     *
     * @param node Поддерево в котором надо искать минимальный элемент
     * @return Узел, содержащий минимальный элемент
     */
    default DefaultBinaryTree.TreeNode<T> getMinNode(DefaultBinaryTree.TreeNode<T> node) {
        return (node == null || node.getLeft() == null) ? node : getMinNode(node.getLeft());
    }

    /*
      Реализации без рекурсии (для сравнения)

    default DefaultBinaryTree.TreeNode<T> getMinNode(DefaultBinaryTree.TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

     */

    /**
     * Поиск минимального TreeNode
     *
     * @return Узел, содержащий минимальный элемент
     */
    default DefaultBinaryTree.TreeNode<T> getMinNode() {
        return getMinNode(getRoot());
    }

    /**
     * Поиск минимального значение
     *
     * @return Минимальное значение
     */
    default T getMin() {
        DefaultBinaryTree.TreeNode<T> minNode = getMinNode();
        return (minNode == null) ? null : minNode.getValue();
    }

    /**
     * Поиск максимального TreeNode в поддереве node
     *
     * @param node Узел дерева
     * @return Узел, содержащий максимальный элемент
     */
    default DefaultBinaryTree.TreeNode<T> getMaxNode(DefaultBinaryTree.TreeNode<T> node) {
        return (node == null || node.getRight() == null) ? node : getMaxNode(node.getRight());
    }

    /**
     * Поиск максимального TreeNode
     *
     * @return Узел, содержащий минимальный элемент
     */
    default DefaultBinaryTree.TreeNode<T> getMaxNode() {
        return getMaxNode(getRoot());
    }

    /**
     * Поиск максимального значение
     *
     * @return Минимальное значение
     */
    default T getMax() {
        DefaultBinaryTree.TreeNode<T> minNode = getMinNode();
        return (minNode == null) ? null : minNode.getValue();
    }

    /**
     * Поиск TreeNode с наибольшим значением, меньшим или равным value, в
     * поддереве node
     *
     * @param node Узел дерева
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    default DefaultBinaryTree.TreeNode<T> getFloorNode(DefaultBinaryTree.TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return getFloorNode(node.getLeft(), value);
        } else {
            DefaultBinaryTree.TreeNode<T> res = getFloorNode(node.getRight(), value);
            return (res != null) ? res : node;
        }
    }

    /**
     * Поиск TreeNode с наибольшим значением, меньшим или равным value
     *
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    default DefaultBinaryTree.TreeNode<T> getFloorNode(T value) {
        return getFloorNode(getRoot(), value);
    }

    /**
     * Поиск наибольшего значения, меньшего или равного value
     *
     * @param value Параметр
     * @return Искомое значение
     */
    default T getFloor(T value) {
        DefaultBinaryTree.TreeNode<T> floorNode = getFloorNode(value);
        return (floorNode == null) ? null : floorNode.getValue();
    }

    /**
     * Поиск TreeNode с наименьшим значением, большим или равным value, в
     * поддереве node
     *
     * @param node Узел дерева
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    default DefaultBinaryTree.TreeNode<T> getCeilingNode(DefaultBinaryTree.TreeNode<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.getValue());
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return getCeilingNode(node.getRight(), value);
        } else {
            DefaultBinaryTree.TreeNode<T> res = getCeilingNode(node.getLeft(), value);
            return (res != null) ? res : node;
        }
    }

    /**
     * Поиск TreeNode с наименьшим значением, большим или равным value
     *
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    default DefaultBinaryTree.TreeNode<T> getCeilingNode(T value) {
        return getCeilingNode(getRoot(), value);
    }

    /**
     * Поиск наименьшего значения, меньше или равного value
     *
     * @param value Параметр
     * @return Искомое значение
     */
    default T getCeiling(T value) {
        DefaultBinaryTree.TreeNode<T> ceilingNode = getCeilingNode(value);
        return (ceilingNode == null) ? null : ceilingNode.getValue();
    }
}
