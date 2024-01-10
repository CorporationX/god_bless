package Synchronization_7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        User user1 = new User("Sasha", Sex.MALE);
        User user3 = new User("Pasha", Sex.MALE);
        User user5 = new User("Gosha", Sex.MALE);
        User user7 = new User("Grisha", Sex.MALE);
        User user2 = new User("Masha", Sex.FEMALE);
        User user4 = new User("Dasha", Sex.FEMALE);
        User user6 = new User("Ksysha", Sex.FEMALE);
        User user8 = new User("Polina", Sex.FEMALE);
        UserList.addUser(user1);
        UserList.addUser(user2);
        UserList.addUser(user3);
        UserList.addUser(user4);
        UserList.addUser(user5);
        UserList.addUser(user6);
        UserList.addUser(user7);
        UserList.addUser(user8);

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            executor.submit(() -> {
                User chatingUser = UserList.getOnlineUsers().get(finalI);
                chatingUser.setUpReadyToContact(true);
                if (!chatingUser.isChatting()) {
                    ChatManager.startChat(chatingUser);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Main thread is failed");
                }
                ChatManager.endChat(chatingUser);
            });
        }

        executor.shutdown();
    }
}
