package faang.school.godbless.sprint2.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
@Slf4j
public class ChatList {
    private List<Chat> chatList;

    public List<Chat> getWaitingChatList() {
        return chatList.stream().filter((chat) -> chat.getSecondUser() == null).toList();
    }

    public void addChat(Chat chat) {
        chatList.add(chat);
        log.info(String.format("%s создал чат %s", chat.getOwnerUser().getUsername(), chat.getId()));
    }
}
