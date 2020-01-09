package com.queue;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-01-09 14:10
 */
public class DoubleArrayQueue {

    private int head = 0;
    private int tail = 0;
    private int length = 0;
    private String[] data;


    public DoubleArrayQueue() {

    }

    public void setQueueLength(int size) {
        this.length = size;
        this.data = new String[size];
    }

    public boolean inQueue(String e) {
        if ((this.tail + 1) % this.length == this.head) {
            System.out.println("Queue is full");
            return false;

        }

        this.data[this.tail] = e;
        System.out.println("doubleIn: " + this.data[this.tail]);
        tail++;
        return true;
    }

    public String outQueue() {
        if (this.head == this.tail) {
            System.out.println("Queue is empty");
            return "false";
        }
        String out = this.data[this.head];
        System.out.println("doubleOut: " + out);
        head++;
        return out;
    }
}
