package org.walmart;

class Message {
    private final int order;
    private final String content;

    public Message(int order, String content) {
        this.order = order;
        this.content = content;
    }

    public int getOrder() {
        return order;
    }

    public String getMsg() {
        return content;
    }
}
