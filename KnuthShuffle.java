import java.util.Arrays;

public class KnuthShuffle {
    
    public static void shuffle(Comparable[] items) {
        int N = items.length;
        for (int i = 0; i < N; i++) {
            int exchPos = (int) (Math.random() * (i+1));
            exch(items, i, exchPos);
        }
    }

    private static void exch(Comparable[] a, int pos1, int pos2) {
        Comparable temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }
   
}