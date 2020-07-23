public class QuickUnionUF {
    
    private int[] lst;

    QuickUnionUF(int length) {
        lst = new int[length];

        for (int i = 0; i < length; i++) {
            lst[i] = i;
        }
    }

    public int findRoot(int i) {
        while (lst[i] != i) {
            i = lst[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        return findRoot(j) == findRoot(i);
    }

    public void union(int i, int j) {
        if (!isConnected(i, j)) {
            int iRoot = findRoot(i);
            int jRoot = findRoot(j);
            lst[iRoot] = jRoot;
        }
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < lst.length; i++) {
            str += lst[i] + " ";
        }

        return str;
    }
}