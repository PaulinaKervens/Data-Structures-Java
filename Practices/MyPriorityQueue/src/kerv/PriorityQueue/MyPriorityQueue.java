
package MyPriorityQueue.src.kerv.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueue<K, V> {

    /** Determines how keys are compared. */
    private Comparator<K> comparator;

    /** Stores the entries in the heap. */
    private List<Entry<K, V>> heap;

    public MyPriorityQueue(Comparator<K> comparator) {
        if (comparator == null) {
            throw new NullPointerException("Comparator cannot be null...");
        }

        this.comparator = comparator;
        this.heap = new ArrayList<>();
    }

    public void insert(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);

        // Add the entry to the heap.
        heap.add(entry);

        // Restore the heap property.
        upHeap(heap.size() - 1);
    }

    /** Moves an entry upward until the heap property is restored. */
    private void upHeap(int j) {
        while (j > 0) {
            int parentIndex = getParent(j);

            if (comparator.compare(
                    heap.get(j).getKey(),
                    heap.get(parentIndex).getKey()) >= 0)
            {
                break;
            }

            swap(j, parentIndex);
            j = parentIndex;
        }
    }

    /** Exchanges two entries in the heap. */
    private void swap(int j, int parentIndex) {
        Entry<K, V> temporary = heap.get(j);

        heap.set(j, heap.get(parentIndex));
        heap.set(parentIndex, temporary);
    }

    public int getParent(int j) {
        return (j - 1) / 2;
    }

    public int getLeftChild(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    public int getRightChild(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    /** Stores a key and its associated value. */
    static class Entry<K, V> {

        private V value;
        private K key;

        /** Parameterized constructor. */
        Entry(K key, V value) {
            if (key == null) {
                throw new NullPointerException("Key cannot be null...");
            }

            if (value == null) {
                throw new NullPointerException("Value cannot be null...");
            }

            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }
}
