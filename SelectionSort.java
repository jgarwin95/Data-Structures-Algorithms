import java.util.Arrays;

public class SelectionSort {
    
    public static void sort(Comparable[] items) {

        int N = items.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(items[j], items[min])) {
                    min = j;
                }
            }
            exch(items, i, min);
        }
    }

    private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // test client
        Integer[] x = {3, 6, 1, 9, 2};
        System.out.println(Arrays.toString(x));
        SelectionSort.sort(x);
        System.out.println(Arrays.toString(x));


    }
}