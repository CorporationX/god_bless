package heart;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
public class Chat {
    private final Map<Message, String> chatContent = new HashMap<>();

    public synchronized void sendMessage(@NonNull Message message, @NonNull String userName) {
        if (message.isValid()) {
            chatContent.put(message, userName);
            printMessage(message, userName);
        }
    }

    private void printMessage(@NonNull Message message, @NonNull String userName) {
        log.info(String.format("[%s] %s: %s", message.getTimestamp(), userName, message.getContent()));
    }

    public void printChatHistory() {
        log.info("");
        chatContent.entrySet().stream()
                .sorted(Comparator.comparing(m -> m.getKey().getTimestamp()))
                .forEach(e -> log.info(String.format("[%s] %s: %s",
                        e.getKey().getTimestamp(), e.getValue(), e.getKey().getContent())));
    }
}
