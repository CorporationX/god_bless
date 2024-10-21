package school.faang.tinder;

import lombok.extern.slf4j.Slf4j;
import school.faang.tinder.exceptions.UserAlreadyInChatException;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    public static void main(String[] args) {
        UserList userList = new UserList();
        User kolya = new User(1, "Коля", true, true);
        User andrey = new User(2, "Андрей", true, true);
        User kostya = new User(3, "Костя", true, true);
        User misha = new User(4, "Миша", true, true);
        User vova = new User(5, "Вова", true, true);

        userList.addUser(kolya);
        userList.addUser(andrey);
        userList.addUser(kostya);
        userList.addUser(misha);
        userList.addUser(vova);

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executor = Executors.newFixedThreadPool(userList.getSize());
        for (User user : userList.getUsers()) {
            executor.submit(() -> {
                try {
                    int chatId = chatManager.startChat(user);
                    Chat chat = chatManager.getChat(chatId);
                    var message = chat.sendMessage("Hello World!", user);
                    chat.removeMessage(message);
                    Thread.sleep(5_000);
                    chatManager.endChat(chatId);
                } catch (UserAlreadyInChatException e) {
                    log.error(user + " уже находится в чате");
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    log.error(Arrays.toString(e.getStackTrace()));
                }
            });
        }
        executor.shutdown();
    }
}
