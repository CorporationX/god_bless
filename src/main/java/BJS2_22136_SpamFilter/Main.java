package BJS2_22136_SpamFilter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter exclamationMarkFilter = message -> !message.contains(":)");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, exclamationMarkFilter);

        String[] messages = {"Hello!", "This is spam!", "How are you? :)", "In galaxy far far away long time ago..."};

        for (String message : messages) {
            boolean isFiltered = MessageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | passed: " + isFiltered);
        }
    }
}
