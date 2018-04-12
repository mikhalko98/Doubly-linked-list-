public class PriorityQueueOnList implements PriorityQueue {
    private Node first;

    public PriorityQueueOnList() {
        first = null;
    }

    @Override
    public void offer(int value) {
        Node temp = new Node();
        temp.setValue(value);
        if (first == null) {
            first = temp;
        } else {
             Node current;
            if (Integer.compare(value, first.getValue())<= 0) {
                temp.setNext(first);
                first.setPrev(temp);
                first = temp;
                return;
            }
            current = first;
            while (current.getNext() != null) {
                if (Integer.compare(value, current.getValue())> 0) {
                    //if (current.getNext() == null) break;
                    current = current.getNext();
                } else {
                    temp.setNext(current);
                    temp.setPrev(current.getPrev());
                    current.setPrev(temp);
                    current = current.getPrev().getPrev();
                    current.setNext(temp);
                    return;
                }
            }
//            assert current != null;
            if (current.getNext() == null) {
                temp.setNext(null);
                temp.setPrev(current);
                current.setNext(temp);
            }
        }
    }

    @Override
    public void remove() {
        first = first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        int i = 0;
        Node temp = first;
        while (temp!=null){
            i++;
            temp = temp.getNext();
        }
        return i;
    }

    @Override
    public void show() {
        Node temp = first;
        while (temp != null) {
            System.out.println("Value = " +temp.getValue());
            temp = temp.getNext();
        }
        if(isEmpty()) System.out.println("Empty");
    }

    public class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
