package faang.school.godbless.spamfilters;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.equalsIgnoreCase("spam");
        MessageFilter emptyFilter = String::isEmpty;
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> message.contains("\\uD83D\\uDE00");

        List<MessageFilter> filters = List.of(spamFilter, emptyFilter, lengthFilter, emojiFilter);

        String [] messages = {"Hello", "It is not a spam", "How are you? :)", " "};

        for (String message: messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("This message: " + message + " -> will be removed -> " + isFiltered);
        }
    }
}
