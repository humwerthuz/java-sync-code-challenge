package org.walmart;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerService {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>(10);
        UseCase useCase = new UseCase();

        new Thread(new Producer(queue)).start();

        new Thread(new Consumer("Thread1", queue, useCase)).start();

        new Thread(new Consumer("Thread2", queue, useCase)).start();

        new Thread(new Consumer("Thread3", queue, useCase)).start();

        System.out.println("Producer and Consumer has been started");
    }
}
