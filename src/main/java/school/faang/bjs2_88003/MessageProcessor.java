package school.faang.bjs2_88003;

import java.util.List;

public class MessageProcessor {

    protected boolean processMessage(String word, List<MessageFilter> filter) {
        for (MessageFilter messageFilter : filter) {
            if (!messageFilter.filter(word)) {
                return false;
            }
        }
        return true;
    }
}
