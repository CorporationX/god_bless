package faang.school.godbless.spam_filter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter greetingFilter = (message) -> message.toLowerCase().contains("hello");
        MessageFilter lengthFilter = (message) -> message.length() > 15;
        MessageFilter emojiFilter = (message) -> message.toLowerCase().contains("emoji");
        MessageFilter isUpperCaseFilter = (message) -> message.equals(message.toUpperCase());

        List<MessageFilter> messageFilters = Arrays.asList(greetingFilter, lengthFilter, emojiFilter, isUpperCaseFilter);

        String[] messages = new String[]{"Hello", "This message is long", "Emoji is used", "BIG", "no filters"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.println("Message " + message + " | Is filtered: " + isFiltered);
        }
    }
}
