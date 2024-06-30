package faang.school.godbless.BJS2_12881;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ChatList {
    private final List<Chat> chats = new ArrayList<>();

    public Chat addChat(User firstUser, User secondUser) {
        Chat chat = new Chat(firstUser, secondUser);
        chats.add(chat);
        return chat;
    }
}
