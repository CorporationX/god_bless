package school.faang.filterspam;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters) {
        for (MessageFilter filter : filters) {
            if (!filter.filter(message)) {
                return false;
            }
        }
        return true;
    }
}
