package Collections;

public class MyQueue {
    int[] data;
    int front;
    int size;

    public MyQueue() {
        data = new int[16];
        front = 0;
        size = 0;
    }

    public MyQueue(int cap) {
        data = new int[cap];
        front = 0;
        size = 0;

    }


    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; size > i; i++) {
            int index = (front + i) % data.length;
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }

    public void add(int val) {
        if (size == data.length) {
            int[] ndata = new int[data.length * 2];
            for (int i = 0; size > i; i++) {
                int idx = (front + i) % data.length;
                ndata[i] = data[idx];
            }
            data = ndata;
            front=0;
            int rear = (front + size) % data.length;
            data[rear] = val;
        } else {
            // special case for circular queue
            int rear = (front + size) % data.length;
            data[rear] = val;
            size++;
        }
    }

    public int remove() {
        if (size == 0) {
            // System.out.println("Queue underflow");
            return -1;
        } else {
            int val = data[front];
            // edge case when front goes out of bounds
            front = (front + 1) % data.length;
            size--;
            return val;
        }
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Queue underflow");
            return -1;
        } else {
            return data[front];
        }
    }


}
