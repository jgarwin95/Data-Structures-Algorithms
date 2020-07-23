public class WeightedQuickUnionUF extends QuickUnionUF{

    private int[] sz;
    private int[] lst;

    WeightedQuickUnionUF(int length) {
        super(length);

        for (int i = 0; i < length; i++){
            sz[i] = 1;
        }
    }

    @Override
    public int findRoot(int i) {
        while (lst[i] != i) {
            // path compression line
            lst[i] = lst[lst[i]];
            i = lst[i];
        }

        return i;
    }

    @Override
    public void union(int i, int j) {
        if (!isConnected(i, j)) {
            int iRoot = findRoot(i);
            int jRoot = findRoot(j);

            if (sz[jRoot] > sz[iRoot]) {
                lst[iRoot] = jRoot;
                sz[jRoot] += sz[iRoot];
            }
            else {
                lst[jRoot] = iRoot;
                sz[iRoot] += sz[jRoot];
            }
        }
        
    }
}