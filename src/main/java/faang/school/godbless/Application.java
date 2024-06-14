package faang.school.godbless;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;
        MessageFilter emojiFilter = message -> !message.contains("😀");
        MessageFilter emailFilter = message -> !message.contains("@");

        List<MessageFilter> filters = Arrays.asList(spamFilter, lengthFilter, emojiFilter, emailFilter);

        String[] messages = {"Hi!", "This spam!", "How are you? 😀", "A long message without spam and emojis",
                "Message over 10 symbols", "Message", "email@mail.ru"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }
}
