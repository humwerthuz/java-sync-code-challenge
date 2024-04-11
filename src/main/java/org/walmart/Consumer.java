package org.walmart;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Message> queue;
    private UseCaseInterface useCase;
    private String name;

    public Consumer(String name, BlockingQueue<Message> q, UseCaseInterface useCase){
        this.useCase=useCase;
        this.queue=q;
        this.name = name;
    }

    @Override
    public void run() {
        Message msg;
        for(;;){
            try {
                msg = queue.take();
                if (Objects.equals(msg.getMsg(), "exit")) {
                    break;
                }
                System.out.println("Consumer " + this.name + " got message " + msg.getMsg());
                this.useCase.process(msg);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}