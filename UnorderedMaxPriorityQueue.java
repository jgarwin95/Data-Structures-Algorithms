public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    UnorderedMaxPriorityQueue() {
        pq = (Key[]) new Comparable[1];
        N = 0;
    }

    private void resize(int length) {
        // if resizing, create new array double the size of previous and copy contents
        Key[] temp = (Key[]) new Comparable[length];

        for (int i = 0; i < N; i++) {
            temp[i] = pq[i];
        }

        pq = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key item) {
        // increment number of items
        N++;
        if (N > pq.length) {
            resize(pq.length*2);
        }
        
        pq[N - 1] = item;
    }

    public Key deleteMax() {
        if (N == 0) {
            throw new IndexOutOfBoundsException();
        }
        int max = 0;
        
        // iterate through list (O(N) operation) to determine max.
        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        //instead of shuffling, exchange with last item
        exch(max, N-1);
        //return last item and decrement.
        N--;
        if (N <= pq.length/4) {
            resize(pq.length/2);
        }
        return pq[N];
    }

    private boolean less(int from, int to) {
        return pq[from].compareTo(pq[to]) < 0;
    }

    private void exch(int from, int to) {
        Key temp = pq[to];
        pq[to] = pq[from];
        pq[from] = temp;
    }
    

    public static void main(String[] args) {
        UnorderedMaxPriorityQueue<Integer> x = new UnorderedMaxPriorityQueue<Integer>();
        x.insert(88);
        x.insert(2);
        x.insert(120);
        x.insert(3);
        x.insert(4);
        System.out.println(x.deleteMax());
        System.out.println(x.deleteMax());
        System.out.println(x.deleteMax());
        System.out.println(x.deleteMax());
    }
}