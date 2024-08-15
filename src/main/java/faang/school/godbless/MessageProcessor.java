package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MessageProcessor {
    public void processMessage(String consumentMessage, List<MessageFilter> messageFilters) {
        boolean isFiltered = messageFilters.stream()
                .allMatch(messageFilter -> messageFilter.filter(consumentMessage));

        if (isFiltered) {
            System.out.println("Message \"" + consumentMessage + "\" passed all filters ");
        } else {
            System.out.println("Message \"" + consumentMessage + "\" didn't passed all filters");
        }
    }
}