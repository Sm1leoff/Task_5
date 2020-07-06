package ru.vsu.cs.course1.tree.bst;

/**
 * Реализация словаря на базе простого (наивного) дерева поиска
 *
 * @param <K>
 * @param <V>
 */
public class SimpleBSTreeMap<K extends Comparable<K>, V> implements DefaultBSTreeMap<K, V> {

    private final DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> tree = new SimpleBSTree<>();

    public SimpleBSTreeMap() throws Exception {
    }

    @Override
    public DefaultBSTree<DefaultBSTreeMap.MapTreeEntry<K, V>> getTree() {
        return tree;
    }
}
