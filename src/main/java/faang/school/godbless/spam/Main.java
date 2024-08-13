package faang.school.godbless.spam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter filterSpam = message -> !message.contains("spam");
        MessageFilter filterSmiles = message -> !message.matches(".*[()]+.*");
        MessageFilter filterLength = message -> message.length() >= 5;

        List<MessageFilter> filters = new ArrayList<>(List.of(filterSpam, filterSmiles, filterLength));

        String words = "Hello how) spam I";
        String[] messages = {"Hi", "It's not a spam", "How r u)", "It's normal message"};

        Arrays.stream(words.split(" ")).forEach(word -> System.out.println(word + " " + messageProcessor.processMessage(word, filters)));

        Arrays.stream(messages).forEach(message -> System.out.println(message + " passed on by filters : " + messageProcessor.processMessage(message, filters)));
    }
}
