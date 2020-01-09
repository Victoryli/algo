package com.queue;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-01-09 14:39
 */
public class LinkListQueue {


    //  队列的队首和队尾
    private Node head = null;
    private Node tail = null;

    public static void main(String[] args) {
        LinkListQueue linkListQueue = new LinkListQueue();
        linkListQueue.inQueue("1");
        linkListQueue.inQueue("2");
        linkListQueue.inQueue("3");
        linkListQueue.outQueue();
        linkListQueue.outQueue();
        linkListQueue.outQueue();
    }

    //入队
    public void inQueue(String value) {
        if (head == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    //出队
    public String outQueue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return null;
        }
        String out = head.getData();
        head = head.next;
        if (head == null){
            tail = null;
        }
        System.out.println(out);
        return out;

    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
