import java.util.Arrays;

public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        // if lo is equal to hi then you have divided to a single object. This is the base case
        if (hi <= lo) return;
        // setting mid this way to prevent overflow of int value
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (!less(a[mid+1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] items, Comparable[] auxItems, int lo, int mid, int hi) {
        // copy over to auxilliary array
        for (int i = lo; i <= hi; i++) {
            auxItems[i] = items[i];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)                                items[k] = auxItems[j++];
            else if (j > hi)                            items[k] = auxItems[i++];
            else if (less(auxItems[i], auxItems[j]))    items[k] = auxItems[i++];
            else                                        items[k] = auxItems[j++]; 
        }
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void main(String[] args) {
        // test client
        Integer[] x = {3, 6, 1, 9, 2, 4};
        System.out.println(Arrays.toString(x));
        MergeSort.sort(x);
        System.out.println(Arrays.toString(x));
    }
}