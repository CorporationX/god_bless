package faang.school.godbless.spamfilter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        List<MessageFilter> filters = new ArrayList<>() {{
            add(spamFilter);
            add(lengthFilter);
        }};
        List<String> messages = new ArrayList<>() {{
            add("Hi!");
            add("It's spam");
            add("Long message bigger than 10 symbols");
        }};
        messages.forEach(message -> {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Message: " + message + " | Passed: " + isFiltered);
        });
    }
}
