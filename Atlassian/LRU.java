package Atlassian;

import java.util.HashMap;

class LRUCache {
    int cap;
    int[] keys;
    int[] values;
    int size;
    HashMap<Integer, Integer> keyIndexMap;

    public LRUCache(int capacity) {
        cap = capacity;
        keys = new int[cap];
        values = new int[cap];
        size = 0;
        keyIndexMap = new HashMap<>();
    }

    private void removeKey(int key) {
        int index = keyIndexMap.get(key);
        for (int i = index; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
            keyIndexMap.put(keys[i], i);
        }
        size--;
    }

    private void updateLRU(int key) {
        removeKey(key);
        addKey(key);
    }

    private void addKey(int key) {
        if (size == cap) {
            // Remove the least recently used key-value pair
            int lruKey = keys[0];
            keyIndexMap.remove(lruKey);
            removeKey(lruKey);
        }

        keys[size] = key;
        keyIndexMap.put(key, size);
        size++;
    }

    public int get(int key) {
        if (keyIndexMap.containsKey(key)) {
            updateLRU(key);
            return values[keyIndexMap.get(key)];
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyIndexMap.containsKey(key)) {
            updateLRU(key);
        } else {
            addKey(key);
        }
        values[keyIndexMap.get(key)] = value;
    }
}
