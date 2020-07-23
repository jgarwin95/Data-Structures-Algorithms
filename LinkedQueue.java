import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T>{

    private Node first;
    private Node last;
    
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next(){
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    public void enqueue(T data) {
        if (isEmpty()) {
            first = new Node(data);
            last = first;
            return;
        }

        Node newLast = new Node(data);
        last.next = newLast;
        last = newLast;
    }

    public T dequeue() {
        T item = first.data;

        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        String str = "";

        Node current = first;
        while (current != null) {
            str += current.data + " ";
            current = current.next;
        }

        return str;
    }


    public static void main(String[] args) {
        LinkedQueue<Integer> x = new LinkedQueue<Integer>();
        x.enqueue(1);
        x.enqueue(2);
        x.enqueue(3);
        x.enqueue(4);
        for (int y : x) {
            System.out.println(y);
        }
        /*
        System.out.println(x.toString());
        System.out.println(x.dequeue());
        System.out.println(x.toString());
        System.out.println(x.dequeue());
        System.out.println(x.toString());
        System.out.println(x.dequeue());
        System.out.println(x.toString());
        System.out.println(x.dequeue());
        */
    }
}