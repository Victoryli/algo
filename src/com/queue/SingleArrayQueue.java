package com.queue;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-01-09 13:51
 */
public class SingleArrayQueue {

    private int head = 0;
    private int tail = 0;
    private int length = 0;
    private String[] data;

    public SingleArrayQueue() {

    }

    public void setQueueLength(int size) {
        this.length = size;
        this.data = new String[size];
    }

    public boolean inQueue(String e) {
        if (this.tail == this.length) {

            System.out.println("Queue is full");
            return false;

        }

        this.data[this.tail] = e;
        System.out.println("in: " + this.data[this.tail]);
        tail++;
        return true;
    }

    public String outQueue() {
        if (this.head == this.tail)
            return "false";
        String out = this.data[head];
        System.out.println("out: " + out);
        head++;
        return out;
    }

}
