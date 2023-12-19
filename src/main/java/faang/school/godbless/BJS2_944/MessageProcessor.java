package faang.school.godbless.BJS2_944;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageProcessor {
    public static void main(String[] args) {
        MessageFilter messageFilter1 = message -> !message.equals(message.toUpperCase());
        MessageFilter messageFilter2 = message -> {
            return !message.isEmpty();
        };
        MessageFilter messageFilter3 = message -> message.length() < 12;

        List<MessageFilter> listOfFilters = Arrays.asList(messageFilter1, messageFilter2, messageFilter3);

        String[] messages = {"Hello", "WORLD", "", "I am okay", "anuogborgiwmskldgg"};

        for (String message : messages) {
            boolean isFiltered = processMessage(message, listOfFilters);
            System.out.println("Сообщение: " + message + " | Пропущено: " + isFiltered);
        }
    }

    public static boolean processMessage(String message, List<MessageFilter> listOfFilters){
        for (MessageFilter messageFilter : listOfFilters) {
            boolean a = messageFilter.filter(message);
            if(!a) {
                return false;
            }
        }
        return true;
    }
}
