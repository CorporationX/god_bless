package faang.school.godbless.MattersOfHeart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<User> users = new ArrayList<>();
        users.add(new User(0, "valera"));
        users.add(new User(1, "baba nina"));
        users.add(new User(2, "agash"));
        users.add(new User(3, "woondervaflya"));
        users.add(new User(4, "abu dabi"));
        ChatManager.users.getUsers().addAll(users);
        for (User user : users) {
            executor.execute(() -> {
                try {
                    ChatManager chatManager = new ChatManager(user);
                    chatManager.startChat();
                    Thread.sleep(2000);
                    System.out.println(chatManager.getCurrentUser().getName() + " закончил чат с " + chatManager.getInterlocutor().getName());
                    chatManager.endChat();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
