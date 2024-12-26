package school.faang.task_49143;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws InterruptedException {
        UserList userList = new UserList();

        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        User user4 = new User("User4");

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        user1.setOnline(true);
        user1.setLookingForChat(true);
        user2.setOnline(true);
        user2.setLookingForChat(true);
        user3.setOnline(true);
        user3.setLookingForChat(false);
        user4.setOnline(true);
        user4.setLookingForChat(true);

        ChatManager chatManager = new ChatManager(userList);

        final Thread t1 = new Thread(() -> chatManager.startChat(user1));
        final Thread t2 = new Thread(() -> chatManager.startChat(user2));
        final Thread t3 = new Thread(() -> chatManager.startChat(user3));
        final Thread t4 = new Thread(() -> chatManager.startChat(user4));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}

