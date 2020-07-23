public class LinkedStack {

    private Node first = null;

    private class Node {
        Node next;
        String item;

    }

    public void push(String item) {
        if (isEmpty()) {
            first.item = item;
            return;
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        
        return item;
    }

    public Boolean isEmpty(){
        return first == null;
    }
}