package java.queue;

/**
 * @author liqing
 * @version 1.0
 * @date 2020-01-09 13:55
 */
public class SingleArrayQueueOpt {
    private int head = 0;
    private int tail = 0;
    private int length = 0;
    private String[] data;

    public SingleArrayQueueOpt() {

    }

    public void setQueueLength(int size) {
        this.length = size;
        this.data = new String[size];
    }

    public boolean inQueue(String e) {
        if (this.tail == this.length) {

            if (this.head == 0) {

                System.out.println("Queue is full");
                return false;
            }

            for (int i = 0; i < tail - head; i++) {
                data[i] = data[head];
            }

            tail = tail - head;
            head = 0;

        }

        data[this.tail] = e;
        System.out.println("in: " + data[this.tail]);
        tail++;
        return true;

    }

    public String outQueue() {
        if (this.tail == this.head) {
            System.out.println("Queue is empty");
            return "false";
        }

        String out = this.data[this.head];
        System.out.println("out: " + out);
        head++;
        return out;
    }


}
