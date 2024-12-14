package faang.school.godbless.spam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> messageFilterList) {
        if (message == null || message.isBlank()) {
            System.out.println("Сообщение не может быть пустым!");
            throw new NullPointerException();
        }

        boolean isFiltered = false;
        for (MessageFilter messageFilter : messageFilterList) {
            isFiltered = messageFilter.filter(message);
        }
        return isFiltered;
    }
}
