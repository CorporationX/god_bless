package faang.school.godbless.bjs2_5684;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int MAX_THREAD = 4;

    public static void main(String[] args) throws InterruptedException {

        UserList userList = new UserList();
        User vasya = new User("Vasya", true);
        User dima = new User("Dima", true);
        User sveta = new User("Sveta", true);
        User katya = new User("Katya", true);

        userList.addUser(vasya);
        userList.addUser(dima);
        userList.addUser(sveta);
        userList.addUser(katya);

        ChatManager chatManager = new ChatManager();
        chatManager.setUserList(userList);

        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);

        executor.execute(() -> vasya.startChat(chatManager));
        Thread.sleep(3000);
        executor.execute(() -> sveta.startChat(chatManager));
        Thread.sleep(3000);
        executor.execute(() -> dima.startChat(chatManager));
        Thread.sleep(3000);
        executor.execute(() -> katya.startChat(chatManager));
        Thread.sleep(3000);
        executor.execute(() -> vasya.leaveChat(chatManager));
        Thread.sleep(3000);
        executor.execute(() -> sveta.leaveChat(chatManager));

        executor.shutdown();

        try {
            while (!executor.awaitTermination(1, TimeUnit.HOURS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        chatManager.printCurrentChats();
    }
}
