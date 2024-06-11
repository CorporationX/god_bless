package faang.school.godbless.module1.sprint2.task7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);


        String[] messages = {"Hello!", "This is spam!", "How are you? 😀", "Very long message"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Missed: " + isFiltered);
        }
    }
}
