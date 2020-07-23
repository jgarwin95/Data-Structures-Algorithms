public class QuickFindUF {

    private int[] lst;

    QuickFindUF(int length) {
        lst = new int[length];

        for (int i = 0; i < length; i++) {
            lst[i] = i;
        }
    }

    public boolean connected(int x, int y) {
        return lst[x] == lst[y];
    }

    public void union(int x, int y) {
        if (!connected(x, y)) {
            int xValue = lst[x];

            for (int i = 0; i < lst.length; i++) {
                // change all values of x over to y
                if (lst[i] == xValue) {
                    lst[i] = lst[y];
                }
            }
        }
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < lst.length; i++) {
            str += lst[i] + " ";
        }

        return str;
    }

    public static void main(String[] args) {
        QuickFindUF dc = new QuickFindUF(10);
        System.out.println(dc.toString());
        dc.union(1, 5);
        System.out.println(dc.toString());
        dc.union(3, 5);
        System.out.println(dc.toString());
    }
}