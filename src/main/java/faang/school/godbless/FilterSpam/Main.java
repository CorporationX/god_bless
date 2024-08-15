package faang.school.godbless.FilterSpam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();


        MessageFilter spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.toCharArray().length > 10;
        MessageFilter emojiFilter = message -> message.contains(":)");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);


        String[] messages = {"hi!", "spam!", "dota :)", "long message without spam and emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("message: " + message + " | skipped: " + isFiltered);
            System.out.println(message.toCharArray().length);
        }
    }
}
