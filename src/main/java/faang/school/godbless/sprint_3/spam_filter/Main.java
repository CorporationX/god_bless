package faang.school.godbless.sprint_3.spam_filter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();
        MessageFilter firstSpamFilter = message -> !message.toLowerCase().contains("спам");
        MessageFilter secondSpamFilter = message -> !message.toUpperCase().contains("CASINO");
        MessageFilter startFilter = message -> message.toLowerCase().startsWith("hello");
        MessageFilter lengthFilter = message -> message.length() >= 12;
        MessageFilter emojiFilter = message -> !message.contains("\uD83D\uDE00");
        MessageFilter languageFilter = message -> message.matches("[a-zA-Z !?.,]+");

        List<MessageFilter> list = List.of(firstSpamFilter, secondSpamFilter, startFilter, lengthFilter, emojiFilter, languageFilter);

        boolean firstResult = processor.processMessage("HELLO there this is Natan sending you a message!", list);
        boolean secondResult = processor.processMessage("HELLO there this is Natan sending you a message!\uD83D\uDE00", list);
        System.out.println(firstResult + "---" + secondResult);
    }
}