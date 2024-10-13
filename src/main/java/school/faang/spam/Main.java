package school.faang.spam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.contains("spam");
        MessageFilter creditFilter = message -> !message.contains("loan");
        MessageFilter sportsBettingFilter = message -> !message.contains("online sports betting");
        MessageFilter lengthFilter = message -> message.length() > 10;

        String[] messages = {"How are you?", "This message contains spam", "Join online sports betting!"
        ,"You've been pre-approved for a $50 billion loan from a shitty bank!"};

        List<MessageFilter> filters = Arrays.asList(spamFilter, creditFilter, sportsBettingFilter, lengthFilter);

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Passed the filters: " + isFiltered);
        }
    }
}
