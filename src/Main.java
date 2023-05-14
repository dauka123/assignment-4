import java.util.LinkedList;
import java.util.Random;

class TestingClass{
    private int val;
    public TestingClass(int v) {
        this.val = v;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(val);
    }
}

public class Main {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable<MyTestingClass, String>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            int val = (int )Math.random();
            hashTable.put(new TestingClass(val), "Student " + val);
        }

    }
}