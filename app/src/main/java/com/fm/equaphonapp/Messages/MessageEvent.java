package com.fm.equaphonapp.Messages;

public class MessageEvent
{
    public final String firstMessage;
    public final String secondMessage;

    public MessageEvent(String firstMessage, String secondMessage)
    {
        this.firstMessage = firstMessage;
        this.secondMessage = secondMessage;
    }
    public MessageEvent(String message) {
        this.firstMessage = message;
        secondMessage = null;
    }
}
