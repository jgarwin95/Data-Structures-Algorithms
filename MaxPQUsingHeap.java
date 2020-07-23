import java.util.Arrays;
import java.util.List;

public class MaxPQUsingHeap <Key extends Comparable<Key>> {
    private Key[] data;
    private int N;

    MaxPQUsingHeap() {
        data = (Key[]) new Comparable[2];
        N = 0;
    }

    MaxPQUsingHeap(Key[] array) {
        N = array.length;
        // create Comparable array one size bigger to allow for empty slot 0
        this.data = (Key[]) new Comparable[N+1];

        for (int i = 0; i < N; i++) {
            data[i+1] = array[i];
        }

        // set up heap order
        for (int i = N; i >= 1; i--) {
            sink(i);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key deleteMax() {
        Key max = data[1];
        exchange(1, N--);
        sink(1);
        data[N+1] = null;
        return max;
    }

    public void insert(Key key) {
        N++;
        if (N >= data.length) resize(data.length * 2);
        // insert at last position in heap
        data[N] = key;
        // swim up to final position
        swim(N);
    }

    protected void sink(int k) {
        // while the parent position is less than either child sink down

        while (2*k <= N) {
            int j = 2*k;

            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    protected void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void exchange(int i, int j) {
        Key temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private boolean less(int to, int from) {
        return (data[to].compareTo(data[from]) < 0);
    }

    private void resize(int x) {
        
        Key[] temp = (Key[]) new Comparable[x];
        for (int i = 0; i < N; i++) {
            temp[i] = data[i];
        }
        data = temp;
        
    }

    public String toString() {
        String str = "";
        for (int i = 0; i <= N; i++) {
            str += data[i] + " ";
        }
        return str;
    }


    public static void main(String[] args) {
        Integer[] x = {1,5,15,20};
        MaxPQUsingHeap<Integer> pq = new MaxPQUsingHeap<Integer>(x);
        System.out.println(pq.toString());
        pq.insert(25);
        System.out.println(pq.toString());
        pq.insert(16);
        System.out.println(pq.toString());
        System.out.println(pq.deleteMax());
        System.out.println(pq.toString());

    }

}