package ru.vsu.cs.course1.tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    class TreeNode<T> {
        // Значение, которое хранится в узле
        T value;
        // список потомков
        List<TreeNode<T>> children;

        public TreeNode(T value) {
            this.value = value;
            this.children = new ArrayList<TreeNode<T>>();
        }

        // остальные методы
    }

}
