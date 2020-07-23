import java.util.Arrays;

public class InsertionSort {
    
    public static void sort(Comparable[] items) {
        int N = items.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(items[j], items[j-1])) {
                    exch(items, j, j-1);
                }
                else break;
            }
        }
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void exch(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public static void main(String[] args) {
        // test client
        Integer[] x = {3, 6, 1, 9, 2};
        System.out.println(Arrays.toString(x));
        InsertionSort.sort(x);
        System.out.println(Arrays.toString(x));
    }
}