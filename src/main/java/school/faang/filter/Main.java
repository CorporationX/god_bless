package school.faang.filter;

import java.util.List;

public class Main {
    private static final int MAX_MESSAGE_LENGTH = 20;

    public static void main(String[] args) {
        MessageFilter lengthFilter = message -> message.length() <= MAX_MESSAGE_LENGTH;
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter offensiveFilter = message -> !message.toLowerCase().matches(".*(badword1|badword2).*");

        List<MessageFilter> messageFilters = List.of(lengthFilter, spamFilter, offensiveFilter);

        MessageProcessor messageProcessor = new MessageProcessor();

        String[] testMessages = {"Hello!", "This is a spam message!", "This message contains badword1.",
                "Hello, you have won a million dollars, click on the link to receive the winnings."};

        for (String message : testMessages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.printf("Message: %s | passed all filters: %b%n", message, isFiltered);
        }
    }
}
