public class PriorityQueueOnArray implements PriorityQueue {
    private int[] array1;
    private int ptr1;

    public PriorityQueueOnArray() {
        array1 = new int[2000];
    }

    @Override
    public void offer(int value) {
        int i;
        if (ptr1 == 0) {
            array1[ptr1++] = value;
        } else {
            for (i = ptr1 - 1; i >= 0; i--) {
                if (compare(value, array1[i]) > 0) {
                    array1[i + 1] = array1[i];
                } else {
                    break;
                }
            }
            array1[i + 1] = value;
            ptr1++;
        }
    }

    @Override
    public void remove() {
        --ptr1;
    }

    @Override
    public boolean isEmpty() {
        return ptr1 == 0;
    }

    @Override
    public int size() {
        return ptr1;
    }

    @Override
    public void show() {
        for (int i = ptr1 - 1; i >= 0; i--) {
            System.out.println("Value = " + array1[i]);
        }
        if (isEmpty()) System.out.println("Empty");
    }

    private int compare(int value, int i) {
        return value > i ? 1 : value < i ? -1 : 0;
    }
}
