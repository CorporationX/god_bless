package faang.school.godbless.mattersoftheheart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager();
        User vasya = new User("Vasya", chatManager);
        User dima = new User("Dima", chatManager);
        User sveta = new User("Sveta", chatManager);
        User katya = new User("Katya", chatManager);

        userList.addUser(vasya);
        userList.addUser(dima);
        userList.addUser(sveta);
        userList.addUser(katya);

        chatManager.setUserList(userList);

        ExecutorService executor = null;
        try {
            executor = Executors.newFixedThreadPool(4);
            executor.execute(vasya::startChat);
            Thread.sleep(3000);
            executor.execute(sveta::startChat);
            Thread.sleep(3000);
            executor.execute(dima::startChat);
            Thread.sleep(3000);
            executor.execute(katya::startChat);
            Thread.sleep(3000);
            executor.execute(vasya::leaveFromChat);
            Thread.sleep(3000);
            executor.execute(sveta::leaveFromChat);
        } finally {
            if (executor != null) {
                executor.shutdown();
            }
        }

        while (!executor.awaitTermination(1, TimeUnit.HOURS)) {
        }

        chatManager.printCurrentChats();
    }
}

