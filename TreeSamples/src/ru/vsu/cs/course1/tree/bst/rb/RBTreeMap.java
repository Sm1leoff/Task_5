package ru.vsu.cs.course1.tree.bst.rb;

import ru.vsu.cs.course1.tree.bst.DefaultBSTreeMap;
import ru.vsu.cs.course1.tree.bst.DefaultBSTree;

/**
 * Реализация словаря на базе красно-черных деревьев
 *
 * @param <K>
 * @param <V>
 */
public class RBTreeMap<K extends Comparable<K>, V> implements DefaultBSTreeMap<K, V> {

    private final DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> tree = new RBTree<>();

    @Override
    public DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
