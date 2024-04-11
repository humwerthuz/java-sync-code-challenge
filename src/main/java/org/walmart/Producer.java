package org.walmart;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
        for(int i=1; i<100; i++){
            Message msg = new Message(i, "Order:"+i);
            try {
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Message msg = new Message(-1,"exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
