package faang.school.godbless.synchronizationWaitNotify.matterOfTheHeart;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Getter
@Setter
public class ChatManager {
    private UserList userList;
    private List<Chat> chats;

    private final Random random = new Random();

    public ChatManager(UserList userList) {
        this.userList = userList;
        this.chats = new ArrayList<>();
    }

    public synchronized void startChat(User user) {
        //получаем список доступных для общения пользователей
        while (userList.getOnlineUsers(user).isEmpty()) {
            try {
                waitForChat(user);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        List<User> onlineUsers = userList.getOnlineUsers(user);

        //рандомно выбираем пользователя
        User userToTalk = onlineUsers.get(random.nextInt(onlineUsers.size()));

        //удаляем пользователей из доступных для общения
        userList.removeUserFromAvailable(user);
        userList.removeUserFromAvailable(userToTalk);
        chats.add(new Chat(user, userToTalk));

        System.out.printf("Поток: %s. Был создан чат между пользователями: %s и %s\n",
                Thread.currentThread().getName(), user.getName(), userToTalk.getName());
    }

    private synchronized void waitForChat(User user) throws InterruptedException {
        if (isAlreadyInChat(user)) {
            System.out.printf("Поток: %s. Пользователь %s уже состоит в чате.\n",
                    Thread.currentThread().getName(), user.getName());
        } else {
            System.out.printf("Поток: %s. Пользователь %s ожидает начала чата...\n",
                    Thread.currentThread().getName(), user.getName());
        }
        this.wait();
    }

    public synchronized void endChat(Chat chat) {
        chats.remove(chat);
        userList.addUserToAvailable(chat.getUser1());
        userList.addUserToAvailable(chat.getUser2());
        System.out.printf("Поток: %s. Пользователи %s и %s завершили чат.\n",
                Thread.currentThread().getName(), chat.getUser1().getName(), chat.getUser2().getName());

        this.notifyAll();
    }

    public synchronized Optional<Chat> getChatByUser(User user) {
        Optional<Chat> chatToReturn = Optional.empty();
        for (Chat chat : chats) {
            if (chat.getChatByUser(user).isPresent()) {
                chatToReturn = chat.getChatByUser(user);
            }
        }

        return chatToReturn;
    }

    private boolean isAlreadyInChat(User user) {
        for (Chat chat : chats) {
            if (chat.containsUser(user)) {
                return true;
            }
        }

        return false;
    }
}
