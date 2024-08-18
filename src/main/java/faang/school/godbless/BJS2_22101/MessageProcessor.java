package faang.school.godbless.BJS2_22101;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters) {
        boolean isFiltrated = true;
        for (MessageFilter filter : filters) {
            isFiltrated &= filter.filter(message);
        }
        return isFiltrated;
    }
}
