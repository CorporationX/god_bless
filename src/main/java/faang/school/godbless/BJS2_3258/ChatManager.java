package faang.school.godbless.BJS2_3258;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.*;

@Data
public class ChatManager {
    // Переименованный класс UserList
    @NonNull
    private final Database database;

    public User loginUser(@NonNull String name) {
        return database.getUser(name);
    }

    public User registerUser(@NonNull String name) {
        return database.createUser(name);
    }

    // При использовании очереди ожидания, методы startChat и waitChat по условию задачи не могут работать вместе.
    // Если вызвать waitChat, то мы не добавляем пользователя в очередь ожидания, соответственно добавить его в чат
    // никто не может, а если добавить, то это и будет метод startChat фактически.
    // Поэтому руководствуясь словами "Эта задача предоставляет вам огромное поле для импровизации" было принято решение
    // переделать метод startChat в requestChat, который добавляет пользователя в очередь ожидания
    public void requestChat(User currentUser) {
        database.addWaitingUser(currentUser);
    }

    @SneakyThrows
    public List<Chat> waitChat(User currentUser) {
        synchronized (database) {
            while (true) {
                List<User> waitingUsers = database.getWaitingUsers();
                List<Chat> userChats = database.getUserChats(currentUser);
                if (waitingUsers.contains(currentUser) && waitingUsers.size() > 1) {
                    User waitingUser = waitingUsers.get(0);
                    database.deleteWaitingUser(currentUser);
                    database.deleteWaitingUser(waitingUser);
                    Chat newChat = database.createChat();
                    database.joinChat(currentUser, newChat);
                    database.joinChat(waitingUser, newChat);
                    database.notifyAll();
                    userChats = database.getUserChats(currentUser);
                    return userChats;
                }
                if (!userChats.isEmpty()) {
                    return userChats;
                }
                database.wait();
            }
        }
    }

    public void leaveChat(User currentUser, Chat chat){
        database.leaveChat(currentUser, chat);
    }
}
