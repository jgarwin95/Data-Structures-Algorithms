public class ArrayStack<Item> {
    private Item[] items;
    private int N;

    ArrayStack() {
        this.items = (Item[]) new Object[1];
        N = items.length;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item x) {
        int len = items.length;
        if (N == len) resize(len * 2);
        // place at end of array and increment after
        items[N++] = x;

    }

    public Item pop() {
        if (N == items.length / 4) resize(items.length / 2);
        return items[--N];
    }

    private void resize(int len) {
        Item[] copy = (Item[]) new Object[len];

        for (int i=0; i < N; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }
}