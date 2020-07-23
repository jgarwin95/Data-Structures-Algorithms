import java.util.Arrays;

public class QuickSort {
    
    public static void sort(Comparable[] items) {
        KnuthShuffle.shuffle(items);
        sort(items, 0, items.length - 1);
    }

    public static void sort(Comparable[] items, int lo, int hi) {
        if (hi <= lo) return;
        int mid = partition(items, lo, hi);
        sort(items, lo, mid - 1);
        sort(items, mid + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(a[++i], a[lo])) {       // find item on left side out of place
                if (i == hi) break;
            }
            while (!less(a[--j], a[lo])) {      // find item on right side out of place
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);                      // exchange out of place items
        }
        exch(a, lo, j);                         // exchange to put partition in place
        return j;                               // return position of partition
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void exch(Comparable[] a, int pos1, int pos2) {
        Comparable temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }
    
}