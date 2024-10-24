package school.faang.tinder;

import lombok.extern.slf4j.Slf4j;
import school.faang.tinder.exceptions.UserAlreadyInChatException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    public static void main(String[] args) {
        User kolya = new User(1, "Коля", true, true);
        User andrey = new User(2, "Андрей", true, true);
        User kostya = new User(3, "Костя", true, true);
        User misha = new User(4, "Миша", true, true);
        User vova = new User(5, "Вова", true, true);
        List<User> users = List.of(kolya, andrey, kostya, misha, vova);

        ChatManager chatManager = new ChatManager(users);
        UserList userList = chatManager.getUserList();
        ExecutorService executor = Executors.newFixedThreadPool(users.size());
        for (User user : users) {
            executor.submit(startChatting(chatManager, user));
        }

        User nikita = new User(7, "Никита", true, true);
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userList.addUser(nikita);
        executor.submit(startChatting(chatManager, nikita));
        executor.shutdown();
    }

    private static Runnable startChatting(ChatManager chatManager, User nikita) {
        return () -> {
            try {
                int chatId = chatManager.startChat(nikita);
                Chat chat = chatManager.getChat(chatId);
                var message = chat.sendMessage("Hello World!", nikita);
                chat.removeMessage(message);
                Thread.sleep(20_000);
                chatManager.endChat(chatId);
            } catch (UserAlreadyInChatException e) {
                log.error(nikita + " уже находится в чате");
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        };
    }
}
