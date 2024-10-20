package school.faang.m1s3.bjs2_37459_tinder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        userList.addUser(alice);
        userList.addUser(bob);
        userList.addUser(charlie);

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.submit(() -> chatManager.startChat(alice));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been terminated" + e.getStackTrace());
        }

        service.submit(() -> chatManager.startChat(bob));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been terminated" + e.getStackTrace());
        }

        service.submit(() -> chatManager.startChat(charlie));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been terminated" + e.getStackTrace());
        }

        service.submit(() -> chatManager.endChat(alice));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been terminated" + e.getStackTrace());
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(3, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread has been terminated" + e.getStackTrace());
        }

    }
}
