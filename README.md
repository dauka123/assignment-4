# assignment-4
### MyHashTable
+ ### hash
**description:** This function takes a key of type K and returns the hash value of the key.
```ruby
private int hash(K key) {
        return key.hashCode() % M;
    }
```
+ ### get
**description:** This method that gets value, indexes and bucket. It has loop to get value of the key.
```ruby
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
```
+ ### put
**description:** This method to put elements into the hash table. It gets index and adds them into the bucket.
```ruby
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
```
+ ### contains
**description:** This function checks if the hash table contains a specific value.
```ruby
public boolean contains(V value) {
        for(LinkedList<MyTestingClass<K,V>> list: chain) {
            for(MyTestingClass<K,V> node: list){
                if (node.getValue().equals(value)) return true;
            }
        }
        return false;
    }
```
+ ### remove
**description:** method that removes entry from the hashTable.
```ruby
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
```
