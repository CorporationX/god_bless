package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        UserList userList = new UserList();
        ChatManager chatManager = new ChatManager(userList);

        User user1 = new User("Adil");
        User user2 = new User("Pasha");
        User user3 = new User("Misha");
        User user4 = new User("Dima");

        userList.addUser(user1);
        userList.addUser(user2);
        userList.addUser(user3);
        userList.addUser(user4);

        Thread thread1 = new Thread(() -> {
            user1.setOnline(true);
            chatManager.startChat(user1);
            chatManager.waitForChat(user1);
            user1.setOnline(false);
        });

        Thread thread2 = new Thread(() -> {
            user2.setOnline(true);
            chatManager.startChat(user2);
            chatManager.waitForChat(user2);
            user2.setOnline(false);
            chatManager.endChat(new Chat(user1, user2, "Adil-Pasha"));
        });

        Thread thread3 = new Thread(() -> {
            user3.setOnline(true);
            chatManager.waitForChat(user3);
            user3.setOnline(false);
        });
        Thread thread4 = new Thread(() -> {
            user4.setOnline(true);
            chatManager.startChat(user4);
            chatManager.waitForChat(user4);
            user4.setOnline(false);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
