public class HeapSort <Key extends Comparable<Key>> {

    public static void sort(Comparable[] a) {
        generateHeap(a);
        int N = a.length - 1;
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private static void generateHeap(Comparable[] a) {
        int N = a.length;
        // set up heap order
        for (int i = N/2; i >= 1; i--) {
            sink(a, i - 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int length) {
        // while the parent position is less than either child sink down
        while (2*k + 1 < length) {
            int j = 2*k + 1;
            // if the position at 2*k+1 is greater than 2k, increment j
            if (j < length && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static boolean less(Comparable[] a, int x, int y) {
        return a[x].compareTo(a[y]) < 0;
    }
    
}