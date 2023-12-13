package filterSpam_806;

import java.util.List;

public class MessageProcessor {

    public void processMessage(String message, List<MessageFilter> filters) {
        boolean resultCheckSpam = true;
        for (MessageFilter filterItem : filters) {
            if (filterItem.filter(message)) {
                resultCheckSpam = false;
            }
        }
        if (resultCheckSpam) {
            System.out.println("Сообщение: '" + message + "' прошло проверку на Спам");
        } else System.out.println("Сообщение: '" + message + "' НЕ прошло проверку на Спам");
    }
}