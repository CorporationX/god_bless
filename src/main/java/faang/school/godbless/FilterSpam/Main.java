package faang.school.godbless.FilterSpam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();


        MessageFilter spamFilter = message -> message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() < 3;
        MessageFilter emojiFilter = message -> message.contains("😀");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter);


        String[] messages = {"Hello!", "It`s spam!", "How are you?", "😀", "This is a long letter without spam and emoji"};

        for (String message : messages) {
            SpamCheckStatus isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Skiped: " + isFiltered);
        }
    }
}
