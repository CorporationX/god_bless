package faang.school.godbless.synchronization.tynder;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChatManager chatManager = new ChatManager();
        ExecutorService usersThreads = Executors.newCachedThreadPool();

        UserList userList = chatManager.getUserList();

        userList.addUser(new User("Oleg"));
        userList.addUser(new User("Vasya"));
        userList.addUser(new User("Alex"));
        userList.addUser(new User("Danil"));
        userList.addUser(new User("Yarik"));
        userList.addUser(new User("Ruslan"));
        userList.addUser(new User("Elisey"));
        userList.addUser(new User("Denis"));


        userList.getOnlineUsers().stream()
                .limit(3)
                .forEach(user -> usersThreads.submit(() -> {
                    chatManager.startChat(user);

                    chatManager.sendMessageViaChat(user);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    chatManager.sendMessageViaChat(user);

                    chatManager.endChat(user);
                }));


        usersThreads.shutdown();
        usersThreads.awaitTermination(10, TimeUnit.SECONDS);

        userList.getOnlineUsers().forEach(System.out::println);
    }
}
