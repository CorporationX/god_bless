package faang.school.godbless.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MessageFilter censoredFilter = message -> message.toLowerCase().contains("censored");
        MessageFilter lengthFiler = message -> message.length() > 25;
        MessageFilter emojiFilter = message -> message.contains("0x1F44D");

        List<MessageFilter> messageFilters = new ArrayList<>(List.of(censoredFilter, lengthFiler, emojiFilter));

        String[] messages = {"censored message", "Veeeeeeeeeeeeery long message", "normal message", "Message with 0x1F44D"};

        MessageProcessor messageProcessor = new MessageProcessor();

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, messageFilters);
            System.out.println("Сообщение: " + message + " | Применение фильтра: " + isFiltered);
        }
    }
}
