package faang.school.godbless.dolbahlop.tasks.lambda.FilteringSpam;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter);

        String[] messages = {"Hello!", "This is spam!", "How are you?", "A long message without emoji and spams", "Hello, how are you? This is a long message to pass all filters!"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
