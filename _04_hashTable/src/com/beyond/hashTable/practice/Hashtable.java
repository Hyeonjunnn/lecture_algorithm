package com.beyond.hashTable.practice;

import java.util.LinkedList;

/**
 * <p>Hashtable 클래스
 *
 * <p>packageName    : com.beyond.hashTable.practice
 * <p>fileName       : HashTable
 * <p>author         : hjsong
 * <p>date           : 2025-01-21
 * <p>description    : Hashtable 클래스
 */
/*
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-21        hjsong             최초 생성
 */
public class Hashtable<K, V> {

    private int maxSize;

    private LinkedList<HashNode<K, V>>[] buckets;

    public Hashtable(){
        this(16);
    }

    @SuppressWarnings("unchecked")
    public Hashtable(int maxSize) {
        this.maxSize = maxSize;
        this.buckets = new LinkedList[this.maxSize];

        for (int i = 0; i < this.maxSize; i++) {
            this.buckets[i] = new LinkedList<>();
        } // for i END

    } // Hashtable() END

    public void put(K key, V value){
        int index = hash(key);

        for (HashNode<K, V> node : buckets[index]){
            if (node.key.equals(key)) {
                node.value = value;

                return;
            } // if (node.key.equals(key)) END

        } // for node : buckets[index] END

        buckets[index].add(new HashNode<>(key, value));
    }

    public V get(K key){
        int index = hash(key);

        for (HashNode<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            } // if (node.key.equals(key)) END

        } // for (HashNode<K, V> node : buckets[index]) END

        return null;
    } // V put(K key) END

    public boolean contains(K key) {
        boolean result = false;

        int index = hash(key);

        for (HashNode<K, V> node : buckets[index]){
            if (node.key.equals(key)) {
                result = true;

                break;
            } // if (node.key.equals(key)) END

        } // for (HashNode<K, V> node : buckets[index]) END

        return result;
    }  // boolean contains(K key) END

    public V remove(K key) {
        V  value = null;
        int index = hash(key);

        for (HashNode<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                value = node.value;

                // HashNode를 제거
                buckets[index].remove(node);

                break;
            } // if (node.key.equals(key)) END

        } // for (HashNode<K, V> node : buckets[index]) END

        return value;
    } // V remove(K key) END

    public int size() {
        int size = 0;

        for (LinkedList<HashNode<K, V>> bucket : buckets) {
            size += bucket.size();
        } // for (bucket : buckets) END

        return size;
    } // size() END

    public boolean isEmpty() {

        return (size() == 0);
    }

    private int hash(K key) {

        return Math.abs(key.hashCode() % this.maxSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < buckets.length; i++) {
            LinkedList<HashNode<K, V>> bucket = buckets[i];

            sb.append(i).append(" : ").append(bucket).append("\n");

        }

        return sb.toString();
    }

    private static class HashNode<K, V> {
        private K key;

        private V value;

        private HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        } // HashNode(K key, V value) END

        @Override
        public String toString() {
            return "{key= " + key + ", value = " + value + "}";
        } // toString() END

    } // HashNode<K, V> END

}
