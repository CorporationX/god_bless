package school.faang.spamfilter.main;

import lombok.extern.slf4j.Slf4j;
import school.faang.spamfilter.service.MessageFilter;
import school.faang.spamfilter.service.MessageProcessor;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new MessageProcessor();
        MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
        MessageFilter buyFilter = message -> !message.toLowerCase().contains("buy");
        List<MessageFilter> filters = List.of(spamFilter, buyFilter);
        String[] messages = {
                "Hi, how are you?",
                "It's not spam",
                "hot today",
                "Spam!",
                "can buy it only today"
        };
        for (String message : messages) {
            boolean isFiltered = messageProcessor.processMessage(message, filters);
            log.info("Message: {}. Passed all the filters: {}", message, isFiltered);
        }
    }
}