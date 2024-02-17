package faang.school.godbless.spam_filter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor= new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("Spam");
        MessageFilter lenghtFilter = message -> message.length()>10;
        MessageFilter emojiFilter=message -> message.contains("\uD83D\uDE00");

        List<MessageFilter>filters= Arrays.asList(spamFilter, lenghtFilter, emojiFilter);

        String[] messages = {"Hello", "it\'s spam ", "How are your \uD83D\uDE00", "Long message without spam and emoji"};
        for(String message: messages){
            boolean isFilter = messageProcessor.processMessage(message, filters);
        }

    }
}
