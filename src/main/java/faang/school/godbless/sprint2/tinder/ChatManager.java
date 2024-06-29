package faang.school.godbless.sprint2.tinder;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
@Slf4j
@ToString
public class ChatManager {
    private UserList userList;
    private ChatList chatList;

    @SneakyThrows
    public void startChat(@NonNull User user) {
        if (user.isOnline()) {
            log.info(String.format("%s решил початиться", user.getUsername()));
            user.setWaitChat(true);
            selectChat(user);
        } else {
            log.error(user.getUsername() + " оффлайн. Не может присоединиться к чату");
        }
    }

    private synchronized void selectChat(User user) throws InterruptedException {
        List<User> waitingUsers = userList.getWaitingChatUsers().stream()
                .filter((u) -> !u.getUsername().equals(user.getUsername()))
                .toList();

        if (!chatList.getWaitingChatList().isEmpty()) {
            joinToChat(user);
        }
        else {
            if (waitingUsers.isEmpty()) {
                log.info(String.format("%s ждет, мб люди появятся...", user.getUsername()));
                this.wait();
                log.info(String.format("%s проснулся от ожидания", user.getUsername()));
                joinToChat(user);
            }
            else {
                createChat(user);
                notifyAll();
            }
        }
    }

    private void joinToChat(User user) {
        Chat chat = chatList.getWaitingChatList()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(user.getId() + " у юзера нет чата для подключения"));
        chat.joinSecondUser(user);
    }

    private void createChat(User owner) {
        String chatId = "CHAT_" + owner.getId();
        Chat chat = new Chat(chatId, owner);
        chatList.addChat(chat);
    }
}
