package Telegram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter lengthFilter = message -> message.length() < 20;
        MessageFilter linkFilter = message -> message.contains("https:");
        MessageFilter imageFilter = message -> message.endsWith(".jpg");

        List<MessageFilter> messageFilters = Arrays.asList(lengthFilter, linkFilter, imageFilter);

        String[] messages = {"Hello!", "Here is my new avatar: somepic.jpg", "I tory, but i don't know how to start.."};
        for (String message : messages){
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.println("Received: " + message + " | " + "Rejected " + isFiltered);
        }
    }
}
