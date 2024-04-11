package org.walmart;

import java.util.concurrent.atomic.AtomicInteger;

public class UseCase implements UseCaseInterface {
    private final AtomicInteger lastProcessed = new AtomicInteger(0);

    public void process(Message message) throws Exception {
        if( message.getOrder() < lastProcessed.get() ) {
            throw new Exception("Messages " + message.getMsg() + " out of order");
        }
        if(message.getOrder() == lastProcessed.get()) {
            throw new Exception("Message " + message.getMsg() + " duplicated, same as previous one");
        }
        System.out.println("Processed message "+message.getMsg());
        lastProcessed.set(message.getOrder());
    }

}