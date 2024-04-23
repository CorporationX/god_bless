package faang.school.godbless.MattersOfTheHeart;

import java.util.HashSet;
import java.util.Set;

public class ChatService {
    private final Set<Chat> chats = new HashSet<>();

    public void addChat(Chat chat) {
        chats.add(chat);
    }

    public void removeBadChats() {
        chats.removeIf(chat -> !chat.isGood());
    }

    public boolean isEmpty() {
        return chats.isEmpty();
    }

    public void runChats() {
        chats.forEach(Chat::begin);
    }
}
