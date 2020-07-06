package ru.vsu.cs.course1.tree.bst.avl;

import ru.vsu.cs.course1.tree.bst.DefaultBSTreeMap;
import ru.vsu.cs.course1.tree.bst.DefaultBSTree;

/**
 * Реализация словаря на базе АВЛ-деревьев
 *
 * @param <K>
 * @param <V>
 */
public class    AVLTreeMap<K extends Comparable<K>, V> implements DefaultBSTreeMap<K, V> {

    private final DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> tree = new AVLTree<>();

    @Override
    public DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
