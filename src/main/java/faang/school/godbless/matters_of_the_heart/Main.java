package faang.school.godbless.matters_of_the_heart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int AMOUNT_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {

        UserList userList = new UserList();
        User nikita = new User("Nikita", true, "male");
        User dima = new User("Dima", true, "male");
        User ksenia = new User("Ksenia", true, "female");
        User olga = new User("Olga", true, "female");

        userList.addUser(nikita);
        userList.addUser(dima);
        userList.addUser(ksenia);
        userList.addUser(olga);

        ChatManager chatManager = new ChatManager(userList);
        ExecutorService executor = Executors.newFixedThreadPool(AMOUNT_THREADS);

        executor.execute(() -> nikita.startChat(chatManager));
        Thread.sleep(2000);
        executor.execute(() -> dima.startChat(chatManager));
        Thread.sleep(2000);
        executor.execute(() -> ksenia.startChat(chatManager));
        Thread.sleep(2000);
        executor.execute(() -> olga.startChat(chatManager));
        Thread.sleep(2000);
        executor.execute(() -> nikita.leaveChat(chatManager));
        Thread.sleep(2000);
        executor.execute(() -> olga.leaveChat(chatManager));
        Thread.sleep(2000);
        executor.shutdown();

        try {
            while (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
