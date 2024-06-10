package faang.school.godbless.FilterSpam;

import java.util.List;

public class MessageProcessor {
    boolean processMessage(String string, List<MessageFilter> messageFiltersList) {
        boolean result = false;
        for (MessageFilter mf : messageFiltersList) {
            if (mf.filter(string)) {
                result = true;
            }
        }
        return result;
    }
}
