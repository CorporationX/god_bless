package faang.school.godbless.spam_filtration;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilters) {
        validateMessage(message);
        validateFiltersList(messageFilters);

        for (MessageFilter messageFilter : messageFilters) {
           return messageFilter.filter(message);
        }

        return true;
    }

    private void validateMessage(String message) {
        if (message.isBlank()) {
            throw new IllegalArgumentException("Message can't be empty");
        }

        if (message == null) {
            throw new IllegalArgumentException("Message can't be null");
        }
    }

    private void validateFiltersList(List<MessageFilter> filtersList){
        if(filtersList.isEmpty()){
            throw new IllegalArgumentException("Filters list can't be empty");
        }

        if(filtersList == null){
            throw new IllegalArgumentException("Filters list can't be null");
        }
    }
}
