package filterSpam_806;

import java.util.List;

public class MessageProcessor {

    public void processMessage(String message, List<MessageFilter> filters) {
        boolean resultCheckSpam = false;
        for (MessageFilter filterItem : filters) {
            if (filterItem.filter(message)) {
                resultCheckSpam = true;
                break;
            }
        }
        if (resultCheckSpam) {
            System.out.println("Сообщение: '" + message + "' - это Спам");
        } else System.out.println("Сообщение: '" + message + "' - это не Спам");
    }
}