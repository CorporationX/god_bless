package school.faang.bjs2_69974;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();

        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter lengthFilter = message -> message.length() > 10;

        List<MessageFilter> filters = List.of(spamFilter, lengthFilter);
        String[] messages = {"Hello!", "It's spam!", "Long message without emoji"};

        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            log.info("Сообщение: {} Прошло все фильтры: {}", message, isFiltered);
        }
    }
}