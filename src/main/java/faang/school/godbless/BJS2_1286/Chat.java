package faang.school.godbless.BJS2_1286;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
class Chat {
    private final User user1;
    private final User user2;
    private Map<User, List<String>> chatMessages;

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public void firstUserMessage(String message) {
        sendMessage(user1, message);
    }

    public void secondUserMessage(String message) {
        sendMessage(user2, message);
    }

    public List<String> getFirstUserChatMessages() {
        return chatMessages.get(user1);
    }

    public List<String> getSecondUserChatMessages() {
        return chatMessages.get(user2);
    }

    public Map<User, List<String>> getChatMessages() {
        return chatMessages;
    }

    private void sendMessage(User user, String message) {
        chatMessages.computeIfAbsent(user, m -> new ArrayList<>()).add(message);
        System.out.printf("[%s] %s: %s\n", System.currentTimeMillis(), user.getName(), message);
    }
}