import java.util.LinkedList;

public class MyHashTable<K, V> {
    private LinkedList<MyTestingClass<K, V>>[] chain;
    private int M = 11;
    private int size;
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
    public void put(K key, V value) {
        int index = hash(key);
        if (chain[index] == null){
            chain[index] = new LinkedList<MyTestingClass<K, V>>();
        }
        for (MyTestingClass<K, V> node: chain[index]){
            if(node.getKey().equals(key)){
                node.setValue(value);
                return;
            }
        }
        chain[index].add(new MyTestingClass<K, V>(key, value));
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        if (chain[index] == null) return null;

        for (MyTestingClass<K, V> node: chain[index]){
            if(node.getKey().equals(key)) return node.getValue();
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        if (chain[index] == null) return null;

        for (MyTestingClass<K, V> node: chain[index]){
            if(node.getKey().equals(key)) {
                chain[index].remove(node);
                size--;
                return node.getValue();
            }
        }
        size--;
        return null;
    }
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
}