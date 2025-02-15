package school.faang.filter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageFilter lengthFilter = message -> message.length() <= 20;
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter offensiveFilter = message -> !message.toLowerCase().matches(".*(badword1|badword2).*");

        List<MessageFilter> messageFilters = List.of(lengthFilter, spamFilter, offensiveFilter);

        MessageProcessor messageProcessor = new MessageProcessor();

        String[] testMessages = {"Hello!", "This is a spam message!", "This message contains badword1",
                "Hello, you have won a million dollars, click on the link to receive the winnings."};

        for (String message : testMessages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.println("Message: " + message + "| passed all filters: " + isFiltered);
        }
    }
}
