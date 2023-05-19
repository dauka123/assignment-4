import java.util.LinkedList;

public class MyHashTable<K, V> {
    private LinkedList<MyTestingClass<K, V>>[] chain;
    private int M = 11;
    private int size;
    /*
      MyHashTable is constructor that creates a hashTable
    */
    public MyHashTable() {
        chain = new LinkedList[M];
        size = 0;
    }
    public MyHashTable(int m) {
        this.M = m;
        chain = new LinkedList[M];
        size = 0;
    }
    private int hash(K key) {
        return key.hashCode() % M;
    }
    /*
      put is method used to add elements to the hashTable
    */
    public void put(K key, V value) {
        int index = hash(key);
        if (chain[index] == null) {
            chain[index] = new LinkedList<>();
        }
        for (MyTestingClass<K, V> node : chain[index]) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        chain[index].add(new MyTestingClass<>(key, value));
        size++;
    }

    /*
      get is method used to retrieve the value associated with a key in the hashTable
    */
    public V get(K key) {
        int index = hash(key);
        if (chain[index] == null) {
            return null;
        }
        for (MyTestingClass<K, V> node : chain[index]) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }
    /*
      remove is used to remove a key-value pair from the hash table
    */
    public V remove(K key) {
        int index = hash(key);
        if (chain[index] == null) {
            return null;
        }
        for (MyTestingClass<K, V> node : chain[index]) {
            if (node.getKey().equals(key)) {
                chain[index].remove(node);
                size--;
                return node.getValue();
            }
        }
        return null;
    }
    /*
      contains checks if the hash table contains a specific value
    */
    public boolean contains(V value) {
        for(LinkedList<MyTestingClass<K,V>> list: chain) {
            for(MyTestingClass<K,V> node: list){
                if (node.getValue().equals(value)) return true;
            }
        }
        return false;
    }
    public K getKey(V value) {
        for(LinkedList<MyTestingClass<K,V>> list: chain) {
            for(MyTestingClass<K,V> node: list){
                if (node.getValue().equals(value)) return node.getKey();
            }
        }
        return null;
    }
    public int getSize() {
        return size;
    }
    public K replace(K key, V oldvalue, V newvalue){
        if (contains(oldvalue) == true){
            remove(getKey(oldvalue));
            put(key, newvalue);
        }
        return null;
    }
}